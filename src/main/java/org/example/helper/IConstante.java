package org.example.helper;

public interface IConstante {
    public  static final long TIME_SLEEP = 249;//499;//60_000;// задержка 60 сек = 60_000 милисекунд
    public static final int COUNT_REPEAT = 1;// количество повторов
    public static final int DEFAULT_MULTIPLIER = 1;// множитель
    public static final int DEFAULT_WORK_TIME = 1;// время работы
    public static final int DEFAULT_BREAK_TIME = 1;// перерыв
    public static final int DEFAULT_LONG_BREAK_TIME = 2;// долгий перерыв

    public static final String MSG_WELCOME_POMODORO = "Добро пожаловать в Pomodoro - это приложение для личной эффективности.\n";
    public static final String MSG_COMMANDS_LIST = """
                Доступные команды:
                    -help - помощь
                    -start
                    -d
                    -dstart - использовать значения по умолчанию(-w 25 -b 5 -l 15 -r 1 m-1)
                    -w - сколько работать (мин)\t-> по умолчанию = 25
                    -b - сколько отдыхать (мин)\t-> по умолчанию = 5
                    -l - длинный перерыв после 4го помидора (мин)\t-> по умолчанию = 15
                    -r - количество повторов \t-> по умолчанию = 1
                    -m - множитель(увеличивает время работы не следующих шага) \t-> по умолчанию = 1
                    -exit - выход
                """;
    public static final String MSG_EXAMPLES = """
            Пример 1 : -w 30 -b 5 -r 2 m-2
                1) работа 30 мин отдых 5
                2) работа 60 мин отдых 5
                
            Пример 2 : -start
                
                
            Пример 3 : -dstart    
                запустится выполнение помидора со значениями по умолчанию
            
            """;
}
