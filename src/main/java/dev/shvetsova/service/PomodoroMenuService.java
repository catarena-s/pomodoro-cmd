package dev.shvetsova.service;

import dev.shvetsova.model.PomodoroCommands;
import dev.shvetsova.model.PomodoroStatus;
import dev.shvetsova.model.menu.Menu;
import dev.shvetsova.model.pomodoro.Pomodoro;
import dev.shvetsova.model.pomodoro.PomodoroCustom;
import dev.shvetsova.model.pomodoro.PomodoroDefault;
import dev.shvetsova.model.pomodoro.PomodoroDemo;
import dev.shvetsova.tools.HelpPrinter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static dev.shvetsova.model.pomodoro.PomodoroDefault.*;

public class PomodoroMenuService extends MenuService {
    private final PomodoroCustom pomodoro;
    private final PomodoroDefault pomodoroDefault;
    private final PomodoroDemo pomodoroDemo;
    private PomodoroCommands command;
    private int repeats;
    private int breakTime;
    private int longBreakTime;
    private int workTime;
    private int multiplier;

    public PomodoroMenuService(Menu menu) {
        super(menu);
        pomodoro = new PomodoroCustom();
        pomodoroDefault = new PomodoroDefault();
        pomodoroDemo = new PomodoroDemo();

        repeats = COUNT_REPEAT;
        breakTime = DEFAULT_BREAK_TIME;
        longBreakTime = DEFAULT_LONG_BREAK_TIME;
        workTime = DEFAULT_WORK_TIME;
        multiplier = DEFAULT_MULTIPLIER;
    }


    public PomodoroCommands getCommand() {
        return command;
    }

    public void parseMenuCommand(final String userInput) {
        String[] commands = userInput.split(" ");
        this.command = null;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "-start" -> this.command = PomodoroCommands.START;
                case "-dstart" -> this.command = PomodoroCommands.START_DEFAULT;
                case "-demo" -> this.command = PomodoroCommands.DEMO_MODE;
                case "-help" -> this.command = PomodoroCommands.HELP;
                case "-exit" -> this.command = PomodoroCommands.EXIT;
                default -> parseCommand(commands, i);
            }
        }
    }

    private void parseCommand(final String[] commands, final int i) {
        switch (commands[i]) {
            case "-w":
                workTime = Integer.parseInt(commands[i + 1]);
                break;
            case "-b":
                breakTime = Integer.parseInt(commands[i + 1]);
                break;
            case "-l":
                longBreakTime = (Integer.parseInt(commands[i + 1]));
                break;
            case "-r":
                repeats = (Integer.parseInt(commands[i + 1]));
                break;
            case "-m":
                multiplier = (Integer.parseInt(commands[i + 1]));
                break;
            case "":
                break;
            default: {
                HelpPrinter.printMessage("Некорректная команда.\n");
            }
        }
    }
    private void start(Pomodoro pomodoro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        HelpPrinter.printMessage("""
                        Work (%dmin) -- Break (%dmin) -- Long break (%dmin) -- Repeats = %d
                        Long break on %d-rd step
                        """
                , pomodoro.getWorkTime(), pomodoro.getBreakTime(), pomodoro.getLongBreakTime(),
                pomodoro.getRepeats(), pomodoro.getLongBreakSteps());

        HelpPrinter.printSeparator();
        int step = 1;
        while (step <= pomodoro.getRepeats()) {
            try {
                startPomodoro(pomodoro);
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

    private void startPomodoro(Pomodoro pomodoro) throws InterruptedException {
        int pomodoroStep = pomodoro.getStep();

        boolean isLongBreak = pomodoroStep % pomodoro.getLongBreakSteps() == 0;
        pomodoro.setWorkTime((pomodoroStep > 1) ? pomodoro.getMultiplier() * pomodoro.getWorkTime() : pomodoro.getWorkTime());

        ProgressBarService progressBarService = new ProgressBarService(pomodoro);
        progressBarService.setStep(pomodoroStep);

        printLineProgress(PomodoroStatus.WORK, progressBarService);
        printLineProgress(isLongBreak ? PomodoroStatus.LONG_BREAK : PomodoroStatus.BREAK, progressBarService);

    }

    private void printLineProgress(final PomodoroStatus work,
                                   ProgressBarService progressBarService) throws InterruptedException {
        progressBarService.draw(work);
        HelpPrinter.printEmptySting();
    }

    @Override
    public void execute() {
        HelpPrinter.printMessage(command.getMassage());
        switch (command) {
            case START -> {
                pomodoro.init(workTime, breakTime, longBreakTime, repeats, multiplier);
                start(pomodoro);
            }
            case START_DEFAULT -> start(pomodoroDefault);
            case DEMO_MODE -> start(pomodoroDemo);
            default -> {
            }
        }
    }
}
