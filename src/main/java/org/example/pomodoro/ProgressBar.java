package org.example.pomodoro;

import org.example.helper.HelpPrinter;
import org.example.helper.HelperUtil;
import org.example.helper.IConstante;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ProgressBar extends IConstante {
    private static final String FORMAT_PROGRESS_STRING = "%s%-10s |%6s%% -> [ %s ]\r";
    private Pomodoro pomodoro;
    private String msg;
    private int step = 0;

    public void setStep(int step) {
        this.step = step;
    }

    public ProgressBar(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
    }

    public void draw(PomodoroStatus status) throws InterruptedException {
        final int countDots = 40;
        final int repeats = 6;
        final String dataStrFormat = status.getDataStrFormat();


        final String dataStr = getTime(status, dataStrFormat);

        final String grid = "#";
        msg = status.getMassage();
        String outGrid = "";

        String stringDots = "";
        for (int i = 0; i < countDots; i++) stringDots += ".";
        String progressBar = stringDots;

        long countPick = status.getCountPick(pomodoro);
        double oneStepPercent = (100.0 / countPick) / (countDots * repeats);
        double progress = 0.0;

        DecimalFormat format = HelperUtil.initDecimalFormat();

        int pick = 1;
        while (pick <= countPick) {
            for (int j = 1; j <= countDots; j++) {
                for (int i = 1; i <= repeats; i++) {
                    Thread.sleep(TIME_SLEEP);
                    progress += oneStepPercent;

                    HelpPrinter.printMessage(FORMAT_PROGRESS_STRING, dataStr, msg, format.format(progress), progressBar);

                    MathContext context = new MathContext(3, RoundingMode.HALF_UP);
                    BigDecimal result = new BigDecimal(progress, context);
                    if (result.doubleValue() % 2.5 == 0) {
                        outGrid += grid;
                        progressBar = String.format("%s%." + (stringDots.length() - outGrid.length()) + "s", outGrid, stringDots);
                    }
                }
            }

            HelpPrinter.printMessage(FORMAT_PROGRESS_STRING, dataStr, msg,// format.format(progress)
                    100 * pick / countPick, progressBar);
            pick++;
        }
    }

    private String getTime(PomodoroStatus type, String dataStrFormat) {
        String dataStr;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        if (type == PomodoroStatus.WORK)
            dataStr = String.format(dataStrFormat, step, LocalTime.now().format(formatter));
        else
            dataStr = String.format(dataStrFormat, LocalTime.now().format(formatter));
        return dataStr;
    }



}
