package dev.shvetsova.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Command {
    EXECUTE("Выполнить"),
    EXIT("Работа завершена.\n");
    private final String massage;
}
