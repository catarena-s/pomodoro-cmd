package dev.shvetsova.pomodoro.model;

public class PomodoroCustom extends PomodoroDefault {
    public void init(int workTime, int breakTime, int longBreakTime, int repeats, int multiplier) {
        this.repeats = repeats;
        this.breakTime = breakTime;
        this.longBreakTime = longBreakTime;
        this.workTime = workTime;
        this.multiplier = multiplier;
    }
}
