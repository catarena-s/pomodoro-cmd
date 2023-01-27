package dev.shvetsova.service;

import java.io.IOException;

public interface IMenuService {
    void printMsg();
    void printQuestion();

    void readAnswer() throws IOException;

    void execute() throws IOException;
    String getAnswer();
}
