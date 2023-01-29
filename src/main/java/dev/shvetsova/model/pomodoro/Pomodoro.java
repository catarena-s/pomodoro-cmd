package dev.shvetsova.model.pomodoro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Pomodoro {
    protected static final long TIME_SLEEP = 249;//249;//499;//60_000;// задержка 60 сек = 60_000 миллисекунд
    protected int repeats;
    protected int breakTime;
    protected int longBreakTime;
    protected int longBreakSteps;
    protected int workTime;
    protected int multiplier;
    private int step = 1;

    public long getTimeSleep() {
        return TIME_SLEEP;
    }

    public int getLongBreakSteps() {
        return longBreakSteps;
    }

    public void incrementSteps() {
        step++;
    }
}
