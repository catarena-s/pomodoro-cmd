package dev.shvetsova.model.pomodoro;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PomodoroStatus {
    WORK("Work", "#%02d %9s -%9s | "),
    BREAK("Break", " %12s -%9s | "),
    LONG_BREAK("Long break", " %12s -%9s | ");

    private final String massage;
    private final String dataStrFormat;

//    PomodoroStatus(String string, String dataStrFormat) {
//        this.massage = string;
//        this.dataStrFormat = dataStrFormat;
//    }

//    public String getDataStrFormat() {
//        return dataStrFormat;
//    }
//
//    public String getMassage() {
//        return massage;
//    }

    public long getCountPick(Pomodoro pomodoro) {
        return switch (this) {
            case WORK -> pomodoro.getWorkTime();
            case BREAK -> pomodoro.getBreakTime();
            case LONG_BREAK -> pomodoro.getLongBreakTime();
        };
    }


}
