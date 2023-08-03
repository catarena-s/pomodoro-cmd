package dev.shvetsova.progressBar.service;

import dev.shvetsova.pomodoro.PomodoroStatus;
import dev.shvetsova.pomodoro.model.Pomodoro;
import dev.shvetsova.progressBar.model.ProgressBar;
import dev.shvetsova.tools.HelpPrinter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalTime;

public class ProgressBarService {
    private final MathContext context = new MathContext(4, RoundingMode.HALF_UP);
    private final DecimalFormat decimalFormat = initDecimalFormat();
    private final ProgressBar progressBar;

    public ProgressBarService(Pomodoro pomodoro) {
        this.progressBar = new ProgressBar(pomodoro);
    }

    public void draw(PomodoroStatus status) throws InterruptedException {
        progressBar.initProgressBar(status, LocalTime.now());

        int pick = 1;
        while (pick <= progressBar.getCountPick()) {
            for (int j = 1; j <= ProgressBar.COUNT_DOTS; j++) {
                for (int i = 1; i <= ProgressBar.REPEATS; i++) {
                    Thread.sleep(progressBar.getPomodoro().getTimeSleep());
                    progressBar.incrementProgress();
                    progressBar.setCurrentTime(LocalTime.now());
                    HelpPrinter.printMessage(getCurrentProgressString(progressBar));
                    initProgressBarr(progressBar);
                }
            }

            progressBar.setCurrentTime(LocalTime.now());
            HelpPrinter.printMessage(getPickProgressString(progressBar, pick));
            pick++;
        }
    }

    public void setStep(int step) {
        progressBar.setStep(step);
    }

    private void initProgressBarr(ProgressBar progressBar) {
        BigDecimal result = new BigDecimal(progressBar.getProgress(), context);
        if (result.doubleValue() % 2.5 == 0) {
            progressBar.setOutGrid(ProgressBar.GRID);
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

    private DecimalFormat initDecimalFormat() {
        DecimalFormat format = new DecimalFormat("00.00");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        format.setDecimalFormatSymbols(symbols);
        return format;
    }
}
