package dev.shvetsova.model.pomodoro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pomodoro {
    protected static final long TIME_SLEEP = 249;//249;//499;//60_000;// задержка 60 сек = 60_000 милисекунд
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

    public void incrementSteps() {
        step++;
    }

    public void init(int workTime, int breakTime, int longBreakTime, int repeats, int multiplier) {
        this.repeats = repeats;
        this.breakTime = breakTime;
        this.longBreakTime = longBreakTime;
        this.longBreakSteps = 4;
        this.workTime = workTime;
        this.multiplier = multiplier;
    }
}
