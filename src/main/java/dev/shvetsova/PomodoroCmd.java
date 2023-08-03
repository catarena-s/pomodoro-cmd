package dev.shvetsova;

import dev.shvetsova.pomodoro.PomodoroCommands;
import dev.shvetsova.menu.model.PomodoroMenu;
import dev.shvetsova.menu.model.WelcomeMenu;
import dev.shvetsova.menu.service.IMenuService;
import dev.shvetsova.menu.service.PomodoroMenuService;
import dev.shvetsova.menu.service.WelcomeMenuService;

import java.io.IOException;

public class PomodoroCmd {
    public static void main(String[] args) throws IOException {
        run();
    }
    public static void run() throws IOException {
        PomodoroMenuService pomodoroMenuService;

        IMenuService welcomeMenuService = new WelcomeMenuService(new WelcomeMenu());

        welcomeMenuService.printMsg();
        welcomeMenuService.printQuestion();

        do {
            String answer = welcomeMenuService.getAnswer();
            if (answer.equals("2")) return;
            if (answer.equals("1")) break;
            welcomeMenuService.execute();
        } while (true);

        pomodoroMenuService = new PomodoroMenuService(new PomodoroMenu());
        pomodoroMenuService.printMsg();
        do {
            pomodoroMenuService.printQuestion();
            pomodoroMenuService.parseMenuCommand(pomodoroMenuService.getAnswer());
            if (pomodoroMenuService.getCommand() != null) {
                if (PomodoroCommands.EXIT.equals(pomodoroMenuService.getCommand())) break;
                pomodoroMenuService.execute();
            }
        } while (true);
    }
}
