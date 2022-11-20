package org.example.pomodoro;

import org.example.helper.HelpPrinter;
import org.example.helper.HelpReader;
import org.example.helper.IConstante;

import java.io.IOException;

/***
 * -help
 * -w время работы
 * -b время отдыха
 * -r количество помидоров
 */
public class PomodoroCmd extends IConstante {

    private Pomodoro pomodoro;

    public PomodoroCmd() {
        HelpPrinter.printMessage(IConstante.MSG_WELCOME_POMODORO);
        HelpPrinter.printSeparator();
        HelpPrinter.printCommands();
        HelpPrinter.printSeparator();
        HelpPrinter.printEmptySting();
        pomodoro = new Pomodoro();
    }

    public void run() throws IOException {
        Menu.setPomodoro(pomodoro);
        Menu menu;

        while (true) {
            menu = Menu.getMenu(HelpReader.readLine());
            if (menu == null) continue;
            menu.run();
            if (menu == Menu.EXIT) break;
        }
    }


    /*
     * -w 1 -b 1 -l 2 -r 1 -m 2
     */
   /* public void initPomodoro() throws IOException {
//        String[] comands = readLine().split(" ");
        for (int i = 0; i < comands.length; i++) {
            switch (comands[i]) {
                case "-help" : HelpPrinter.helpMessage();break;
                case "-d" : {
                    pomodoro.repeats = IConstante.COUNT_REPEAT;
                    pomodoro.breakTime = IConstante.DEFAULT_BREAK_TIME;
                    pomodoro.longBreakTime = IConstante.DEFAULT_LONG_BREAK_TIME;
                    pomodoro.workTime = IConstante.DEFAULT_WORK_TIME;
                    pomodoro.multiplier = IConstante.DEFAULT_MULTIPLIER;
                    break;
                }
                case "-w" : pomodoro.workTime = Integer.parseInt(comands[++i]);break;
                case "-b" : pomodoro.breakTime = Integer.parseInt(comands[++i]);break;
                case "-l" : pomodoro.longBreakTime = Integer.parseInt(comands[++i]);break;
                case "-r" : pomodoro.repeats = Integer.parseInt(comands[++i]);break;
                case "-m" : pomodoro.multiplier = Integer.parseInt(comands[++i]);break;
                case "-exit" : System.exit(0);break;

            }
        }
    }
*/

  /*  public void start(int pomodoroStep) throws InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        HelpPrinter.printMessage(LocalTime.now().format(formatter));

        boolean isLongBreak = pomodoroStep % 4 == 0;

        pomodoro.workTime = (pomodoroStep > 1) ? pomodoro.multiplier * pomodoro.workTime : pomodoro.workTime;

        HelpPrinter.printMessage(String.format("Work time: %dmin >> Break time: %dmin ",
                pomodoro.workTime, isLongBreak ? pomodoro.longBreakTime : pomodoro.breakTime));

        progressBar.draw(PomodoroStatus.WORK);

        System.out.print("\n");

        HelpPrinter.printMessage(LocalTime.now().format(formatter));
        progressBar.draw(PomodoroStatus.BREAK);

        System.out.print("\n");

        HelpPrinter.printMessage(LocalTime.now().format(formatter));

        System.out.print("\n\n");
    }
*/
    private void drawProgress(PomodoroStatus type) throws InterruptedException {
        /*String symbol = "#";
        String out = "";

        int pick = 1;
        Long countPick = 0L;
        String msg = "";
        switch (type) {
            case WORK : {
                countPick = workTime * IConstante.TIME_CONVERTER / IConstante.TIME_STEP;
                msg = "Work progress:";
                break;
            }
            case BREAK : {
                countPick = breakTime * IConstante.TIME_CONVERTER / IConstante.TIME_STEP;
                msg = "Break progress:";
                break;
            }
            case LONG_BREAK : {
                countPick = longBreakTime * IConstante.TIME_CONVERTER / IConstante.TIME_STEP;
                msg = "Long break progress:";
            }
        }
        float persen =(float)(100/countPick)/(20*12);
        float progress =0.0f;
        while (pick <= countPick) {
            out += symbol;
            String progressBar = out;
            *//*
             TIME_SLEEP = 500;//
             TIMER = 60_000;// (60_000/(500 * 10)) = 12
            COUNT_PROGRESS = 10;
             *//*
// -w 1 -b 1
// -w 5 -b 0

            for (int i = 1; i <= 8; i++) {
                progressBar = out;
                for (int j = 1; j <= 30; j++) {
                    Thread.sleep(249);
                    progress+=persen;
                    System.out.print(String.format("%s %.2f%% ->[ %s ]\r", msg, progress, progressBar));
                    progressBar += symbol;
//                    persen=persen*j*i;
                }
              //  progress=persen*20;
            }
            System.out.print(String.format("%s %d%% ->[ %s ]\r", msg, 100 * pick / countPick, progressBar));
            pick++;*/
//        }

    }
}
