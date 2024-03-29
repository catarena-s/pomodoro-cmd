package dev.shvetsova.tools;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final String MSG_WELCOME_POMODORO = "\033[1;30;43;51m Добро пожаловать в Pomodoro - это приложение для личной эффективности. \033[0m\n";
    public static final String MSG_COMMANDS_LIST = """
            \033[36m Доступные команды:
             -start
             -dstart - использовать значения по умолчанию(-w 25 -b 5 -l 15 -r 1 m-1)
             -w - установить время для работаты (мин)\t-> по умолчанию = 25
             -b - установить время для отдыхата (мин)\t-> по умолчанию = 5
             -l - длинный перерыв после 4го помидора (мин)\t-> по умолчанию = 15
             -r - количество повторов \t-> по умолчанию = 1
             -m - множитель(увеличивает время работы не следующих шага) \t-> по умолчанию = 1
             -help - помощь
             -demo - демонстрация в укоренном режие
             -exit - выход \033[0m
                """;
    public static final String MSG_EXAMPLES = """
            \033[36m Пример 1 : -w 30 -b 5 -r 2 m-2 \033[0m
            \033[36;3m    1) работа 30 мин отдых 5
                2) работа 60 мин отдых 5\033[0m
             \033[36m    
            Пример 2 : -start
                
            Пример 3 : -dstart    
                запустится выполнение помидора со значениями по умолчанию
             \033[0m
            """;
}
