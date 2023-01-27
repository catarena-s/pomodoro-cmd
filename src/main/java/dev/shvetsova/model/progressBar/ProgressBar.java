package dev.shvetsova.model.progressBar;

import dev.shvetsova.model.pomodoro.Pomodoro;
import dev.shvetsova.model.pomodoro.PomodoroStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Getter
@Setter
public class ProgressBar {
    public static final String FORMAT_PROGRESS_STRING = "%s%-17s |%6s%% -> [ %s ]\r";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final String GRID = "#";
    public static final int COUNT_DOTS = 40;
    public static final int REPEATS = 6;
    private final Pomodoro pomodoro;
    private long countPick;
    private String begin;
    private double oneStepPercent;
    private double progress;
    private String dataStrFormat;
    private String msg;
    private PomodoroStatus currentStatus;
    private String stringDots = "";
    private StringBuilder outGrid;
    private String progressBarString;
    private String currentTime;
    private int step = 0;

    public ProgressBar(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
        for (int i = 0; i < COUNT_DOTS; i++) stringDots += ".";
    }
    public double incrementProgress() {
        progress += oneStepPercent;
        return progress;
    }

    public void initProgressBar(PomodoroStatus currentStatus, LocalTime beginTime) {
        this.currentStatus = currentStatus;
        this.begin = beginTime.format(formatter);

        progress = 0.0;
        outGrid = new StringBuilder("");
        progressBarString = stringDots;
        dataStrFormat = currentStatus.getDataStrFormat();
        countPick = currentStatus.getCountPick(pomodoro);
        msg = currentStatus.getMassage() + "(" + countPick + "min)";
        oneStepPercent = (100.0 / countPick) / (COUNT_DOTS * REPEATS);
    }
    public void setOutGrid(String outGrid) {
        this.outGrid.append(outGrid);
    }
    public void setCurrentTime(LocalTime currentTime) {
        String time = currentTime.format(formatter);

        if (currentStatus == PomodoroStatus.WORK)
            this.currentTime = String.format(dataStrFormat, step, begin, time);
        else
            this.currentTime = String.format(dataStrFormat, begin, time);
    }
 /*   public void setProgressBarString(String progressBarString) {
        this.progressBarString = progressBarString;
    }




    public void setStep(int step) {
        this.step = step;
    }

    public Pomodoro getPomodoro() {
        return pomodoro;
    }*/
/*    public double getOneStepPercent() {
        return oneStepPercent;
    }*/


  /*  public double getProgress() {
        return progress;
    }

    public String getBegin() {
        return begin;
    }

    public double getOneStepPercent() {
        return oneStepPercent;
    }

    public String getDataStrFormat() {
        return dataStrFormat;
    }*/

   /* public String getMsg() {
        return msg;
    }

    public PomodoroStatus getCurrentStatus() {
        return currentStatus;
    }

    public String getOutGrid() {
        return outGrid.toString();
    }

    public String getStringDots() {
        return stringDots;
    }

    public String getProgressBarString() {
        return progressBarString;
    }
    public long getCountPick() {
        return countPick;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public int getStep() {
        return step;
    }*/



//    public String getCurrentProgressString() {
//        DecimalFormat decimalFormat = HelperUtil.initDecimalFormat();
//        return String.format(FORMAT_PROGRESS_STRING, currentTime
//                , msg, decimalFormat.format(progress), progressBarString);
//    }

//    public String getPickProgressString(int pick) {
//        DecimalFormat decimalFormat = HelperUtil.initDecimalFormat();
//        return String.format(FORMAT_PROGRESS_STRING, currentTime,
//                msg, 100 * pick / countPick, progressBarString);
//    }

//    public void initProgressBarr() {
//        MathContext context = new MathContext(4, RoundingMode.HALF_UP);
//        BigDecimal result = new BigDecimal(getProgress(), context);
//        if (result.doubleValue() % 2.5 == 0) {
//            outGrid += ProgressBar.GRID;
//            progressBarString = String.format("%s%." +
//                    (stringDots.length() - outGrid.length()) + "s", outGrid, stringDots);
//        }
//    }
}
