package dev.shvetsova.model.menu;

import dev.shvetsova.model.menu.Menu;
import dev.shvetsova.tools.IConstante;

public class WelcomeMenu extends Menu {
    public WelcomeMenu() {
        msg = IConstante.MSG_WELCOME_POMODORO;
        question = "Для начала работы с помодоро нажмите - 1, для выхода -2 \n";
    }
}
