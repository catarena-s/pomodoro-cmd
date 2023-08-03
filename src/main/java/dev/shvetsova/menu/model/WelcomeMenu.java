package dev.shvetsova.menu.model;

import dev.shvetsova.tools.Constants;

public class WelcomeMenu extends Menu {
    public WelcomeMenu() {
        msg = Constants.MSG_WELCOME_POMODORO;
        question = "Для начала работы с помодоро нажмите - 1, для выхода -2 \n";
    }
}
