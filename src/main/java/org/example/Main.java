package org.example;

import org.example.pomodoro.PomodoroCmd;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        PomodoroCmd pomodoro = new PomodoroCmd();
        pomodoro.initPomodoro();
        pomodoro.writeMsg("Количество повторов: "+ pomodoro.getRepeats());
        int step = 1;
        while (step <= pomodoro.getRepeats()) {
            pomodoro.writeMsg(String.format("Pomodoro step #%d:",step));
            pomodoro.start(step);
            step++;
        }
    }
}