package dev.shvetsova.service;

import dev.shvetsova.model.menu.Menu;
import dev.shvetsova.tools.HelpPrinter;
import dev.shvetsova.tools.HelpReader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Getter
@Slf4j
public abstract class MenuService implements IMenuService {
    private final Menu menu;
    protected String answer;

    protected MenuService(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void printMsg() {
        HelpPrinter.printMessage(menu.getMsg());
    }

    @Override
    public void printQuestion() {
        HelpPrinter.printMessage(menu.getQuestion());
    }

    @Override
    public void readAnswer() throws IOException {
        answer = HelpReader.readLine();
    }
}
