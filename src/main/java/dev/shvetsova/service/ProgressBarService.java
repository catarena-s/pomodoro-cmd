package dev.shvetsova.service;

import dev.shvetsova.model.pomodoro.Pomodoro;
import dev.shvetsova.model.pomodoro.PomodoroStatus;
import dev.shvetsova.tools.HelpPrinter;
import dev.shvetsova.tools.HelperUtil;
import dev.shvetsova.model.progressBar.ProgressBar;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalTime;
//@RequiredArgsConstructor
@Slf4j
public class ProgressBarService {
    private final MathContext context = new MathContext(4, RoundingMode.HALF_UP);
    private final DecimalFormat decimalFormat = HelperUtil.initDecimalFormat();
    //    private static final String FORMAT_PROGRESS_STRING = "%s%-16s |%6s%% -> [ %s ]\r";
    private final ProgressBar progressBar;
//    private final Pomodoro pomodoro;


    public ProgressBarService(Pomodoro pomodoro) {
//        this.pomodoro = pomodoro;
        this.progressBar = new ProgressBar(pomodoro);
    }

    public void draw(PomodoroStatus status) throws InterruptedException {
        progressBar.initProgressBar(status, LocalTime.now());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        final int countDots = 40;
//        final int repeats = 6;
//        final String dataStrFormat = status.getDataStrFormat();
//        String begin = LocalTime.now().format(formatter);
//        progressBar.setBegin();
//        String dataStr;//= getTime(status, dataStrFormat,begin,"");

//        final String grid = "#";

//        String outGrid = "";
//        String stringDots = "";
//
//        for (int i = 0; i < ProgressBar.countDots; i++) stringDots += ".";
//        String progressBarString = progressBar.stringDots;

//        long countPick = status.getCountPick(pomodoro);
//        final String msg = status.getMassage() + "(" + progressBar.countPick + "min)";

//        double oneStepPercent = (100.0 / progressBar.countPick) / (ProgressBar.countDots * ProgressBar.repeats);
//        double progress = 0.0;

//        DecimalFormat decimalFormat = HelperUtil.initDecimalFormat();

        int pick = 1;
        while (pick <= progressBar.getCountPick()) {
            for (int j = 1; j <= ProgressBar.COUNT_DOTS; j++) {
                for (int i = 1; i <= ProgressBar.REPEATS; i++) {
//                    if (progressBar.getPomodoro().isDemoMode())
//                        Thread.sleep(IConstante.TIME_SLEEP_DEMO);
//                    else
                    Thread.sleep(progressBar.getPomodoro().getTIME_SLEEP());
//                    progress += progressBar.oneStepPercent;
//                    dataStr = getTime(status, dataStrFormat, begin, LocalTime.now().format(formatter));
                    progressBar.incrementProgress();
                    progressBar.setCurrentTime(LocalTime.now());
                    HelpPrinter.printMessage(getCurrentProgressString(progressBar));
                    initProgressBarr(progressBar);

//                    if (result.doubleValue() % 2.5 == 0) {
//                        outGrid += ProgressBar.GRID;
//                        progressBarString = String.format("%s%." +
//                                (progressBar.stringDots.length() - outGrid.length()) + "s", outGrid, progressBar.stringDots);
//                    }
                }
            }

            /*String endTime =*/
            progressBar.setCurrentTime(LocalTime.now());
//            String endTime = getTime(status, dataStrFormat, begin, LocalTime.now().format(formatter));
            HelpPrinter.printMessage(getPickProgressString(progressBar, pick));
            pick++;
        }
    }

    public void setStep(int step) {
        progressBar.setStep(step);
    }

    //    private String getTime(PomodoroStatus type, String dataStrFormat, String begin, String end) {
    //        String dataStr;
    //
    //        if (type == PomodoroStatus.WORK)
    //            dataStr = String.format(dataStrFormat, progressBar.getStep(), begin, end);
    //        else
    //            dataStr = String.format(dataStrFormat, begin, end);
    //        return dataStr;
    //    }
    private void initProgressBarr(ProgressBar progressBar) {
        BigDecimal result = new BigDecimal(progressBar.getProgress(), context);
        if (result.doubleValue() % 2.5 == 0) {
            progressBar.setOutGrid(ProgressBar.GRID);//progressBar.getOutGrid() +
            String format = "%s%." + (progressBar.getStringDots().length() - progressBar.getOutGrid().length()) + "s";
            progressBar.setProgressBarString(String.format(format, progressBar.getOutGrid(), progressBar.getStringDots()));
        }
    }


    private String getPickProgressString(ProgressBar progressBar, int pick) {

        return String.format(ProgressBar.FORMAT_PROGRESS_STRING, progressBar.getCurrentTime(),
                progressBar.getMsg(), 100L * pick / progressBar.getCountPick(), progressBar.getProgressBarString());
    }

    private String getCurrentProgressString(ProgressBar progressBar) {
        return String.format(ProgressBar.FORMAT_PROGRESS_STRING, progressBar.getCurrentTime()
                , progressBar.getMsg(), decimalFormat.format(progressBar.getProgress()), progressBar.getProgressBarString());
    }
}
