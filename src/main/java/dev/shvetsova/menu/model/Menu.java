package dev.shvetsova.menu.model;

import lombok.Getter;

@Getter
public abstract class Menu {
    protected String msg;
    protected String question;
    protected boolean hasQuestion = true;
}
