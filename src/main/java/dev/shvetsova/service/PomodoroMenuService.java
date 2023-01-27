package dev.shvetsova.service;

import dev.shvetsova.model.PobodoroCommands;
import dev.shvetsova.model.menu.Menu;
import dev.shvetsova.model.pomodoro.Pomodoro;
import dev.shvetsova.model.pomodoro.PomodoroDefault;
import dev.shvetsova.model.pomodoro.PomodoroDemo;
import dev.shvetsova.model.pomodoro.PomodoroStatus;
import dev.shvetsova.tools.HelpPrinter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static dev.shvetsova.model.pomodoro.PomodoroDefault.*;
public class PomodoroMenuService extends MenuService {
    private final Pomodoro pomodoro;
    private final PomodoroDefault pomodoroDefault;
    private final PomodoroDemo pomodoroDemo;
    private PobodoroCommands command;
    private int repeats;
    private int breakTime;
    private int longBreakTime;
    private int workTime;
    private int multiplier;
    //    private int step = 1;

    public PomodoroMenuService(Menu menu) {
        super(menu);
        pomodoro = new Pomodoro();
        pomodoroDefault = new PomodoroDefault();
        pomodoroDemo = new PomodoroDemo();

        repeats = COUNT_REPEAT;
        breakTime = DEFAULT_BREAK_TIME;
        longBreakTime = DEFAULT_LONG_BREAK_TIME;
        workTime = DEFAULT_WORK_TIME;
        multiplier = DEFAULT_MULTIPLIER;
        //     this.pomodoro = new Pomodoro();
//        progressBarService = new ProgressBarService(pomodoro);
//        progressBar = new ProgressBar(pomodoro);
//        this.progressBar = progressBar;
    }

//    private  ProgressBar progressBar;

    public PobodoroCommands getCommand() {
        return command;
    }

    public void executeCommand() {

    }

    public void initMenu(final String userInput) {
        String[] commands = userInput.split(" ");
        this.command = null;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "-start": {
                    this.command = PobodoroCommands.START;
                    break;
                }
                case "-dstart": {
                    this.command = PobodoroCommands.START_DEFAULT;
                    break;
                }
                case "-demo": {
                    this.command = PobodoroCommands.DEMO_MODE;
                    break;
                }
                case "-help": {
                    this.command = PobodoroCommands.HELP;
                    break;
                }
                case "-exit": {
                    this.command = PobodoroCommands.EXIT;
                    break;
                }
//                case "-w":
//                    pomodoro.setWorkTime(Integer.parseInt(commands[++i]));
//                    break;
//                case "-b":
//                    pomodoro.setBreakTime(Integer.parseInt(commands[++i]));
//                    break;
//                case "-l":
//                    pomodoro.setLongBreakTime(Integer.parseInt(commands[++i]));
//                    break;
//                case "-r":
//                    pomodoro.setRepeats(Integer.parseInt(commands[++i]));
//                    break;
//                case "-m":
//                    pomodoro.setMultiplier(Integer.parseInt(commands[++i]));
//                    break;
//                case "":
//                    break;
                default: {
                    parseCommand(commands, i);
//                    HelpPrinter.printMessage("Некорректная команда.\n");
                }
            }
        }
//        return menu;
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
//        log.info("Pomodoro завершен {}", LocalTime.now().format(formatter));
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
        HelpPrinter.printMessage( command.getMassage());
        switch (command) {
            case START: {
                pomodoro.init(workTime, breakTime, longBreakTime, repeats, multiplier);
                start(pomodoro);
                break;
            }
            case START_DEFAULT: {
                start(pomodoroDefault);
                break;
            }
            case DEMO_MODE: {
                start(pomodoroDemo);
                break;
            }
            default:
                return;
        }
    }
}
