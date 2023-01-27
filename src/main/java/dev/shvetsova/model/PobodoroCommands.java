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

/*    private static Pomodoro pomodoro;
    private static ProgressBar progressBar;*/

    private final String massage;
//
//    public String getMassage() {
//        return this.massage;
//    }
//
//    PobodoroCommands(final String str) {
//        this.massage = str;
//    }

/*    public static void setPomodoro(Pomodoro p) {
        pomodoro = p;
        progressBar = new ProgressBar(pomodoro);
    }*/

/*    public static PobodoroMenu getMenu(String userInput) {
        String[] commands = userInput.split(" ");
        PobodoroMenu current = null;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "-start": {
                    current = START;
                    break;
                }
                case "-dstart": {
                    current = START_DEFAULT;
                    break;
                }
                case "-d": {
                    current = PRINT_DEFAULT;
                    break;
                }
                case "-help": {
                    current = HELP;
                    break;
                }
                case "-exit": {
                    current = EXIT;
                    break;
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
                    parseCommand(commands[i], commands[++i]);
                    HelpPrinter.printMessage("Некорректная команда.\n");
                }
            }
        }
        return current;
    }

    private static void parseCommand(String command, String value) {
        switch (command) {
            case "-w":
                pomodoro.setWorkTime(Integer.parseInt(value));
                break;
            case "-b":
                pomodoro.setBreakTime(Integer.parseInt(value));
                break;
            case "-l":
                pomodoro.setLongBreakTime(Integer.parseInt(value));
                break;
            case "-r":
                pomodoro.setRepeats(Integer.parseInt(value));
                break;
            case "-m":
                pomodoro.setMultiplier(Integer.parseInt(value));
                break;
            case "":
                break;
            default: {
                HelpPrinter.printMessage("Некорректная команда.\n");
            }
        }
    }*/

/*    public void executeCommand() {
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
            default:
                return;
        }
    }*/
/*
    private void start() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        HelpPrinter.printMessage(
                "Work (%dmin) -- Break (%dmin) -- Long break (%dmin) " +
                        "-- Repeats = %d  \n"
                , pomodoro.getWorkTime(), pomodoro.getBreakTime(), pomodoro.getLongBreakTime(),
                pomodoro.getRepeats());

        HelpPrinter.printSeparator();
        int step = 1;
        while (step <= pomodoro.getRepeats()) {
            try {
                startPomodoro();
                step++;
                pomodoro.incrementSteps();
                HelpPrinter.printSeparator();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        HelpPrinter.printEmptySting();
        HelpPrinter.printMessage("Pomodoro завершен %s\n", LocalTime.now().format(formatter));
    }

    private void startPomodoro() throws InterruptedException {
        int pomodoroStep = pomodoro.getStep();
        boolean isLongBreak = pomodoroStep % LONG_BREAK_STEPS == 0;
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
    }*/
}
