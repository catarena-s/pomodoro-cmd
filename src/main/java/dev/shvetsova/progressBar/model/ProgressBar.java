package dev.shvetsova.progressBar.model;

import dev.shvetsova.pomodoro.PomodoroStatus;
import dev.shvetsova.pomodoro.model.Pomodoro;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

import static dev.shvetsova.tools.Constants.FORMATTER;

@Getter
@Setter
public class ProgressBar {
    public static final String FORMAT_PROGRESS_STRING = "%s%-17s |%6s%% -> [ %s ]\r";
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
    private String stringDots;
    private StringBuilder outGrid;
    private String progressBarString;
    private String currentTime;
    private int step = 0;

    public ProgressBar(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
        stringDots = ".".repeat(COUNT_DOTS);
    }
    public void incrementProgress() {
        progress += oneStepPercent;
    }
    public void initProgressBar(PomodoroStatus currentStatus, LocalTime beginTime) {
        this.currentStatus = currentStatus;
        this.begin = beginTime.format(FORMATTER);

        progress = 0.0;
        outGrid = new StringBuilder();
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
        String time = currentTime.format(FORMATTER);

        if (currentStatus == PomodoroStatus.WORK)
            this.currentTime = String.format(dataStrFormat, step, begin, time);
        else
            this.currentTime = String.format(dataStrFormat, begin, time);
    }
}
