package org.example.pomodoro;

import org.example.helper.HelpPrinter;
import org.example.helper.IConstante;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public enum Menu {
    START("Старт Pomodoro\n"),
    START_DEFAULT("Старт Pomodoro со значениями по умолчанию\n"),
    HELP(IConstante.MSG_COMMANDS_LIST + IConstante.MSG_EXAMPLES),
    EXIT("Работа завершена.\n"),
    PRINT_DEFAULT("Значения по умолчанию\n");

    private static Pomodoro pomodoro;
    private static ProgressBar progressBar;

    private String massage = "";

    Menu(String str) {
        massage = str;
    }

    public static void setPomodoro(Pomodoro p) {
        pomodoro = p;
        progressBar = new ProgressBar(pomodoro);
    }

    public static Menu getMenu(String userInput) {
        String[] commands = userInput.split(" ");
        for (int i = 0; i < commands.length; i++) {
            switch (userInput) {
                case "-start": {
                    return START;
                }
                case "-dstart": {
                    return START_DEFAULT;
                }
                case "-d": {
                    return PRINT_DEFAULT;
                }
                case "-help": {
                    return HELP;
                }
                case "-exit": {
                    return EXIT;
                }
                case "-w":
                    pomodoro.setWorkTime(Integer.parseInt(commands[++i]));
                    break;
                case "-b":
                    pomodoro.setBreakTime(Integer.parseInt(commands[++i]));
                    break;
                case "-l":
                    pomodoro.setLongBreakTime(Integer.parseInt(commands[++i]));
                    break;
                case "-r":
                    pomodoro.setRepeats(Integer.parseInt(commands[++i]));
                    break;
                case "-m":
                    pomodoro.setMultiplier(Integer.parseInt(commands[++i]));
                    break;
                case "":
                    break;
                default: {
                    HelpPrinter.printMessage("Некорректная команда.\n");
                }
            }
        }
        return null;
    }

    public void run() {
        HelpPrinter.printMessage(this.massage);
        switch (this) {
            case START: {
                start();
                break;
            }
            case START_DEFAULT: {
                startDefault();
                break;
            }
            case PRINT_DEFAULT: {
                printDefault();
                break;
            }
        }
    }

    private void start() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        HelpPrinter.printMessage(
                "Work time(%dmin) -- Break time(%dmin) -- Long break time(%dmin) " +
                        "-- Repeats = %d -- Multiplie = %d \n"
                , pomodoro.getWorkTime(), pomodoro.getBreakTime(), pomodoro.getLongBreakTime(),
                pomodoro.getRepeats(), pomodoro.getMultiplier());

        int step = 1;
        while (step <= pomodoro.getRepeats()) {
            try {
                startPomodoro(step++);
                HelpPrinter.printEmptySting();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            step++;
        }
        HelpPrinter.printEmptySting();
        HelpPrinter.printMessage("Pomodoro завершен %s\n", LocalTime.now().format(formatter));
    }

    private void startPomodoro(int pomodoroStep) throws InterruptedException {
        boolean isLongBreak = pomodoroStep % 2 == 0;
        pomodoro.setWorkTime((pomodoroStep > 1) ? pomodoro.getMultiplier() * pomodoro.getWorkTime() : pomodoro.getWorkTime());

        progressBar.setStep(pomodoroStep);

        printLineProgress(PomodoroStatus.WORK);
        printLineProgress(isLongBreak ? PomodoroStatus.LONG_BREAK : PomodoroStatus.BREAK);

    }

    private void printLineProgress(PomodoroStatus work) throws InterruptedException {
        progressBar.draw(work);
        HelpPrinter.printEmptySting();
    }

    private void printDefault() {
        HelpPrinter.printMessage(pomodoro.getDefault());
    }

    private void startDefault() {
        pomodoro.setDefault();
        start();
    }
}
