package org.example.pomodoro;

import org.example.helper.IConstante;

public class Pomodoro extends IConstante {
    private int repeats;
    private int breakTime;
    private int longBreakTime;
    private int workTime;
    private int multiplier;
    private boolean isDefault;

    public Pomodoro() {
        setDefault();
    }

    public void setDefault() {
        repeats = COUNT_REPEAT;
        breakTime = DEFAULT_BREAK_TIME;
        longBreakTime = DEFAULT_LONG_BREAK_TIME;
        workTime = DEFAULT_WORK_TIME;
        multiplier = DEFAULT_MULTIPLIER;
        isDefault = true;
    }

    public String getDefault() {
        final String format = "-w %d -b %d -l %d -r %d m- %d\n";
        return String.format(format, DEFAULT_WORK_TIME, DEFAULT_BREAK_TIME, DEFAULT_LONG_BREAK_TIME, COUNT_REPEAT, DEFAULT_MULTIPLIER);
    }

    public int getRepeats() {
        return repeats;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }

    public int getLongBreakTime() {
        return longBreakTime;
    }

    public void setLongBreakTime(int longBreakTime) {
        this.longBreakTime = longBreakTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }


}
