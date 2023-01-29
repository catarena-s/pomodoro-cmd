package dev.shvetsova;

import dev.shvetsova.model.PomodoroCommands;
import dev.shvetsova.model.menu.PomodoroMenu;
import dev.shvetsova.model.menu.WelcomeMenu;
import dev.shvetsova.service.IMenuService;
import dev.shvetsova.service.PomodoroMenuService;
import dev.shvetsova.service.WelcomeMenuService;

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
