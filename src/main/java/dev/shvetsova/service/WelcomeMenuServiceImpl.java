package dev.shvetsova.service;

import dev.shvetsova.model.menu.Menu;
import dev.shvetsova.tools.HelpPrinter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class WelcomeMenuServiceImpl extends MenuService {
    static final String NUMBER_FORMAT_EXCEPTION = "Введено некорректное значение.";

    public WelcomeMenuServiceImpl(Menu menu) {
        super(menu);
    }

    @Override
    public void readAnswer() throws IOException {
        boolean isCorrectAnswer;
        do {
            super.readAnswer();
            isCorrectAnswer = checkAnswer();
        } while (!isCorrectAnswer);
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
        switch (answer) {
            case "1":
            case "2":
                break;
            default:
                HelpPrinter.printMessage("Некорректная команда.\n");
        }
    }
}
