package dev.shvetsova.service;

import dev.shvetsova.model.menu.Menu;
import dev.shvetsova.tools.HelpPrinter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class WelcomeMenuService extends MenuService {
    static final String NUMBER_FORMAT_EXCEPTION = "Введено некорректное значение.";

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
            log.error(NUMBER_FORMAT_EXCEPTION);
        }
        return false;
    }

    @Override
    public void execute() {
        if (answer.equals("1") || answer.equals("2")) return;
        HelpPrinter.printMessage("Некорректная команда.\n");
    }
}
