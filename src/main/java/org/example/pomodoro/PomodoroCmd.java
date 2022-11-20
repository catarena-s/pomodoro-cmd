package org.example.pomodoro;

import org.example.helper.HelpPrinter;
import org.example.helper.HelpReader;
import org.example.helper.IConstante;

import java.io.IOException;

/***
 * -help
 * -w время работы
 * -b время отдыха
 * -r количество помидоров
 */
public class PomodoroCmd implements IConstante {

    private Pomodoro pomodoro;

    public PomodoroCmd() {
        HelpPrinter.printMessage(MSG_WELCOME_POMODORO);
        HelpPrinter.printSeparator();
        HelpPrinter.printCommands();
        HelpPrinter.printSeparator();
        HelpPrinter.printEmptySting();
        pomodoro = new Pomodoro();
    }

    public void run() throws IOException {
        Menu.setPomodoro(pomodoro);
        Menu menu;

        while (true) {
            menu = Menu.getMenu(HelpReader.readLine());
            if (menu == null) continue;
            menu.run();
            if (menu == Menu.EXIT) break;
        }
    }
}
