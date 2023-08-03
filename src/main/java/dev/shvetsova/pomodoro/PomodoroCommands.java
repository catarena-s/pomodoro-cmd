package dev.shvetsova.pomodoro;

import dev.shvetsova.tools.Constants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static dev.shvetsova.tools.Constants.MSG_COMMANDS_LIST;

@Getter
@RequiredArgsConstructor
public enum PomodoroCommands {
    START("Старт Pomodoro\n"),
    START_DEFAULT("Старт Pomodoro со значениями по умолчанию\n"),
    DEMO_MODE("Демо режим: \n"),
    HELP(MSG_COMMANDS_LIST + Constants.MSG_EXAMPLES),
    EXIT("Работа завершена.\n");

    private final String massage;
}
