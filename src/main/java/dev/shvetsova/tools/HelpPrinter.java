package dev.shvetsova.tools;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HelpPrinter {
    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printEmptySting() {
        System.out.println();
    }

    public static void printMessage(String messageTemplate, Object... args) {
        System.out.printf(messageTemplate, args);
    }

    public static void printCommands() {
        printMessage(Constants.MSG_COMMANDS_LIST);
    }

    public static void helpMessage() {
        printMessage(Constants.MSG_COMMANDS_LIST + Constants.MSG_EXAMPLES);
    }

    public static void printSeparator() {
        printMessage("-------------------------------------------------------------------------------------------\n");
    }
}
