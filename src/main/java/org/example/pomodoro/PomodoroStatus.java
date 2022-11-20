package org.example.pomodoro;

public enum PomodoroStatus {
    WORK("Work", "#%d %9s | "),
    BREAK("Break", " %11s | "),
    LONG_BREAK("Long break", " %11s | ");

    private String massage;
    private String dataStrFormat;

    PomodoroStatus(String string, String dataStrFormat) {
        this.massage = string;
        this.dataStrFormat = dataStrFormat;
    }
    public String getDataStrFormat() {
        return dataStrFormat;
    }

    public String getMassage() {
        return massage;
    }

    public long getCountPick(Pomodoro pomodoro) {
        return switch (this) {
            case WORK -> pomodoro.getWorkTime();
            case BREAK -> pomodoro.getBreakTime();
            case LONG_BREAK -> pomodoro.getLongBreakTime();
        };
    }



}
