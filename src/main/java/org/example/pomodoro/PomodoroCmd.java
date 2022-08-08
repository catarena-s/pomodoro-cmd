package org.example.pomodoro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/***
 * -help
 * -w время работы
 * -b время отдыха
 * -r количество помидоров
 */
public class PomodoroCmd {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /*
    time*TIME_CONVERTER/TIME_STEP
        1 min -> 1*60/10 = 6
        2 min -> 2*60/10 = 12
        30 min -> 30*60/60 = 30
     */
    private static final long TIME_CONVERTER = 60;// преобразование времени
    private static final long TIME_STEP = 60;// шаг - 60
    private static final long TIME_SLEEP = 499;//60_000;// задержка 60 сек = 60_000 милисекунд
    private static final long TIMER = 60_000;// задержка 60 сек = 60_000 милисекунд
    private static final int COUNT_PROGRESS = 10;
    private static final int COUNT_REPEAT = 1;// количество повторов
    private static final int DEFAULT_MULTIPLIER = 1;// множитель
    private static final int DEFAULT_BREAK_TIME = 1;// перерыв
    private static final int DEFAULT_WORK_TIME = 1;// время работы
    private static final int DEFAULT_LONG_BREAK_TIME = 15;// долгий перерыв


    public int getRepeats() {
        return repeats;
    }

    private int repeats = COUNT_REPEAT;
    private int breakTime = DEFAULT_BREAK_TIME;
    private int longBreakTime = DEFAULT_LONG_BREAK_TIME;
    private int workTime = DEFAULT_WORK_TIME;
    private int multiplier = DEFAULT_MULTIPLIER;

    public PomodoroCmd() {
        writeMsg("Добро пожаловать в Pomodoro - это приложение для личной эффективности.");
        // helpMessage();
        printComands();
    }

    public void writeMsg(String message) {
        System.out.println(message);

    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    private void printComands() {
        writeMsg("""
                Доступные команды:
                -help - помощь
                -d - использовать значения по умолчанию(-w 25 -b 5 -l 15 -r 1 m-1)
                -w - сколько работать (мин)\t-> по умолчанию = 25
                -b - сколько отдыхать (мин)\t-> по умолчанию = 5
                -l - длинный перерыв после 4го помидора (мин)\t-> по умолчанию = 15
                -r - количество повторов \t-> по умолчанию = 1
                -m - множитель(увеличивает время работы не следующих шага) \t-> по умолчанию = 1
                -exit - выход
                """);
    }

    private void helpMessage() {
        writeMsg("""
                Доступные команды:
                -help - помощь
                -d - использовать значения по умолчанию(-w 25 -b 5 -l 15 -r 1 m-1)
                -w - сколько работать (мин)\t-> по умолчанию = 25
                -b - сколько отдыхать (мин)\t-> по умолчанию = 5
                -l - длинный перерыв после 4го помидора (мин)\t-> по умолчанию = 15
                -r - количество повторов \t-> по умолчанию = 1
                -m - множитель(увеличивает время работы не следующих шага) \t-> по умолчанию = 1
                -exit - выход
                Пример : -w 30 -b 5 -r 2 m-2
                1) работа 30 мин отдых 5
                2) работа 60 мин отдых 5
                """);
    }

    /*
     * -w 1 -b 1 -l 2 -r 1 -m 2
     */
    public void initPomodoro() throws IOException {
        String[] comands = readLine().split(" ");
        for (int i = 0; i < comands.length; i++) {
            switch (comands[i]) {
                case "-help" : helpMessage();break;
                case "-d" : {
                    repeats = COUNT_REPEAT;
                    breakTime = DEFAULT_BREAK_TIME;
                    longBreakTime = DEFAULT_LONG_BREAK_TIME;
                    workTime = DEFAULT_WORK_TIME;
                    multiplier = DEFAULT_MULTIPLIER;
                    break;
                }
                case "-w" : workTime = Integer.parseInt(comands[++i]);break;
                case "-b" : breakTime = Integer.parseInt(comands[++i]);break;
                case "-l" : longBreakTime = Integer.parseInt(comands[++i]);break;
                case "-r" : repeats = Integer.parseInt(comands[++i]);break;
                case "-m" : multiplier = Integer.parseInt(comands[++i]);break;
                case "-exit" : System.exit(0);break;

            }
        }
    }


    public void start(int pomodoroStep) throws InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        writeMsg(LocalTime.now().format(formatter));

        boolean isLongBreak = pomodoroStep % 4 == 0;
        workTime = (pomodoroStep > 1) ? multiplier * workTime : workTime;

        writeMsg(String.format("Work time: %dmin >> Break time: %dmin ", workTime, isLongBreak ? longBreakTime : breakTime));
        drawProgress(PomodoroType.WORK);

        System.out.print("\n");

        writeMsg(LocalTime.now().format(formatter));

        System.out.print("\n");

        writeMsg(LocalTime.now().format(formatter));

        System.out.print("\n\n");
    }

    private void drawProgress(PomodoroType type) throws InterruptedException {
        String symbol = "#";
        String out = "";
        int pick = 1;
        Long countPick = 0L;
        String msg = "";
        switch (type) {
            case WORK : {
                countPick = workTime * TIME_CONVERTER / TIME_STEP;
                msg = "Work progress:";
                break;
            }
            case BREAK : {
                countPick = breakTime * TIME_CONVERTER / TIME_STEP;
                msg = "Break progress:";
                break;
            }
            case LONG_BREAK : {
                countPick = longBreakTime * TIME_CONVERTER / TIME_STEP;
                msg = "Long break progress:";
            }
        }

        while (pick <= countPick) {
            out += symbol;
            String progressBar = out;
            /*
             TIME_SLEEP = 500;//
             TIMER = 60_000;// (60_000/(500 * 10)) = 12
            COUNT_PROGRESS = 10;
             */

            for (int i = 0; i < 12; i++) {
                progressBar = out;
                for (int j = 0; j < 10; j++) {
                    Thread.sleep(TIME_SLEEP);
                    System.out.print(String.format("%s %d%% ->[ %s ]\r", msg, 100 * (pick - 1) / countPick, progressBar));
                    progressBar += symbol;
                }
            }
            System.out.print(String.format("%s %d%% ->[ %s ]\r", msg, 100 * pick / countPick, out));
            pick++;
        }

    }
}
