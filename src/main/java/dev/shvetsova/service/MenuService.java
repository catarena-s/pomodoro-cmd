package dev.shvetsova.service;

import dev.shvetsova.model.menu.Menu;
import dev.shvetsova.tools.HelpPrinter;
import dev.shvetsova.tools.HelpReader;

import java.io.IOException;

public abstract class MenuService implements IMenuService {
    private final Menu menu;
    public Menu getMenu() {
        return menu;
    }

    @Override
    public String getAnswer() throws IOException {
        readAnswer();
        return answer;
    }

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

    protected void readAnswer() throws IOException {
        answer = HelpReader.readLine();
    }
}
