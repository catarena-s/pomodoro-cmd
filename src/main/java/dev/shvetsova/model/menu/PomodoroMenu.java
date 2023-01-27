package dev.shvetsova.model.menu;

import dev.shvetsova.tools.IConstante;

public class PomodoroMenu extends Menu {
    public PomodoroMenu() {
        msg = IConstante.MSG_COMMANDS_LIST;
        question = "Введите команду: \n";
    }
}
