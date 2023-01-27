package dev.shvetsova.model.pomodoro;

public class PomodoroDemo extends PomodoroDefault {
    private static final int LONG_BREAK_STEPS = 3;
    public static final long TIME_SLEEP_DEMO = 1;
    public PomodoroDemo() {
        super();
        repeats = 3;
    }

    @Override
    public int getLongBreakSteps() {
        return LONG_BREAK_STEPS;
    }

    @Override
    public long getTimeSleep() {
        return TIME_SLEEP_DEMO;
    }


}
