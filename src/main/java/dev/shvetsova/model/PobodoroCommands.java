package dev.shvetsova.model;

import dev.shvetsova.tools.IConstante;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PobodoroCommands {
    START("Старт Pomodoro\n"),
    START_DEFAULT("Старт Pomodoro со значениями по умолчанию\n"),
    DEMO_MODE("Демо режим: \n"),
    HELP(IConstante.MSG_COMMANDS_LIST + IConstante.MSG_EXAMPLES),
    EXIT("Работа завершена.\n");

    private final String massage;
}
