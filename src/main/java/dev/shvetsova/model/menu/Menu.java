package dev.shvetsova.model.menu;

import lombok.Getter;

@Getter
public abstract class Menu {
    protected String msg;
    protected String question;

    protected boolean hasQuestion = true;

//    public String getQuestion() {
//        return question;
//    }
//
//    public boolean isHasQuestion() {
//        return hasQuestion;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
}
