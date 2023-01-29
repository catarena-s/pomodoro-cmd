package dev.shvetsova.service;

import java.io.IOException;

public interface IMenuService {
    void printMsg();
    void printQuestion();
    void execute() throws IOException;
    String getAnswer() throws IOException;
}
