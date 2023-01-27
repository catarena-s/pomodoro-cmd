package dev.shvetsova;

import dev.shvetsova.model.PobodoroCommands;
import dev.shvetsova.model.menu.PomodoroMenu;
import dev.shvetsova.model.menu.WelcomeMenu;
import dev.shvetsova.service.IMenuService;
import dev.shvetsova.service.PomodoroMenuService;
import dev.shvetsova.service.WelcomeMenuServiceImpl;

import java.io.IOException;

public class PomodoroCmd {

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException {
        PomodoroMenuService pomodoroMenuService;

        IMenuService welcomeMenuService = new WelcomeMenuServiceImpl(new WelcomeMenu());
        welcomeMenuService.printMsg();
        welcomeMenuService.printQuestion();
//        welcomeMenuService.readAnswer();
//        welcomeMenuService.execute();

        String a;
        do {
            welcomeMenuService.readAnswer();
            a = welcomeMenuService.getAnswer();
            welcomeMenuService.execute();
            if (a.equals("2")) return;
        } while (!a.equalsIgnoreCase("1") && !a.equalsIgnoreCase("2"));
//            HelpPrinter.printCommands();
        pomodoroMenuService = new PomodoroMenuService(new PomodoroMenu());
        pomodoroMenuService.printMsg();
        while (true) {
            pomodoroMenuService.printQuestion();
            pomodoroMenuService.readAnswer();
            pomodoroMenuService.initMenu(pomodoroMenuService.getAnswer());
            if (pomodoroMenuService.getCommand() != null) {
                pomodoroMenuService.execute();
                if (pomodoroMenuService.getCommand() == PobodoroCommands.EXIT) break;
            }
        }


//        PobodoroMenu.setPomodoro(pomodoro);
//        PobodoroMenu pobodoroMenu;
/*
        pomodoroMenuService = new PomodoroMenuService();
        while (true) {
//            pobodoroMenu = PobodoroMenu.getMenu(HelpReader.readLine());
//            pobodoroMenu =
            pomodoroMenuService.initMenu(HelpReader.readLine());
            if(pomodoroMenuService.getMenu()!=null){

//            if (pobodoroMenu != null) {
                pomodoroMenuService.executeCommand();
                if (pomodoroMenuService.getMenu() == PobodoroMenu.EXIT) break;
            }
        }
    }
*/
    }
//    private static void printWelcomeMassage() {
//        HelpPrinter.printMessage(MSG_WELCOME_POMODORO);
//        HelpPrinter.printSeparator();
//        HelpPrinter.printCommands();
//        HelpPrinter.printSeparator();
//        HelpPrinter.printEmptySting();
//    }
}
