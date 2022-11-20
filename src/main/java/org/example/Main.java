package org.example;

import org.example.pomodoro.PomodoroCmd;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PomodoroCmd pomodoroCmd = new PomodoroCmd();
        pomodoroCmd.run();
    }
}