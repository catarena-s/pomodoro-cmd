package org.example;

import org.example.helper.HelpPrinter;
import org.example.helper.HelpReader;
import org.example.helper.IConstante;
import org.example.pomodoro.Menu;
import org.example.pomodoro.Pomodoro;

import java.io.IOException;

/***
 * -help
 * -w время работы
 * -b время отдыха
 * -r количество помидоров
 */
public class PomodoroCmd implements IConstante {

    public static void main(String[] args) throws IOException {
        printWelcomeMassage();
        run(new Pomodoro());
    }

    public static void run( Pomodoro pomodoro) throws IOException {
        Menu.setPomodoro(pomodoro);
        Menu menu;

        while (true) {
            menu = Menu.getMenu(HelpReader.readLine());
            if (menu == null) continue;
            menu.run();
            if (menu == Menu.EXIT) break;
        }
    }

    private static void printWelcomeMassage() {
        HelpPrinter.printMessage(MSG_WELCOME_POMODORO);
        HelpPrinter.printSeparator();
        HelpPrinter.printCommands();
        HelpPrinter.printSeparator();
        HelpPrinter.printEmptySting();
    }
}
