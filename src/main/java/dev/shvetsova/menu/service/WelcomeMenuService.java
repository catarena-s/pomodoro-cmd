package dev.shvetsova.menu.service;

import dev.shvetsova.menu.model.Menu;
import dev.shvetsova.tools.HelpPrinter;
import java.io.IOException;

public class WelcomeMenuService extends MenuService {
    static final String NUMBER_FORMAT_EXCEPTION = "Введено некорректное значение.\n";

    public WelcomeMenuService(Menu menu) {
        super(menu);
    }

    @Override
    public void readAnswer() throws IOException {
        do {
            super.readAnswer();
        } while (!checkAnswer());
    }

    private boolean checkAnswer() {
        try {
            Integer.parseInt(answer);
            return true;
        } catch (NumberFormatException ex) {
            HelpPrinter.printMessage(NUMBER_FORMAT_EXCEPTION);
        }
        return false;
    }

    @Override
    public void execute() {
        if (answer.equals("1") || answer.equals("2")) return;
        HelpPrinter.printMessage("Некорректная команда.\n");
    }
}
