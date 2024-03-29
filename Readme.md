## Pomodoro
![Java](https://img.shields.io/badge/java-17-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-1.18.24-red.svg?style=flat&logo=Lombok&logoColor=white)
![Intellj_Idea](https://img.shields.io/badge/intellj_Idea-v2022.12-blue.svg?style=flat&logo=intellij-idea&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-v7.4-green.svg?style=flat&logo=gradle&logoColor=white)

«Метод помидора» — техника управления временем, предложенная Франческо Чирилло в конце 1980-х.
Методика предполагает увеличение эффективности работы при меньших временных затратах за счёт 
глубокой концентрации и коротких перерывов. [Википедия](https://ru.wikipedia.org/wiki/%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D0%BF%D0%BE%D0%BC%D0%B8%D0%B4%D0%BE%D1%80%D0%B0)

## Базовые принципы
1. Определитесь с задачами, которые планируете выполнять, расставьте приоритеты (см. матрица Эйзенхауэра)
2. Установите таймер на 20-25 минут.
3. Работайте, ни на что не отвлекаясь, до сигнала таймера
4. Сделайте короткий перерыв (5 минут).
5. После каждого 4-го «помидора» делайте длинный перерыв (15-30 минут).

## Доступныекоманды
````
Доступные команды:
-start
-dstart - использовать значения по умолчанию(-w 25 -b 5 -l 15 -r 1 m-1)
-w - установить время для работаты (мин)	-> по умолчанию = 25
-b - установить время для отдыхата (мин)	-> по умолчанию = 5
-l - длинный перерыв после 4го помидора (мин)	-> по умолчанию = 15
-r - количество повторов 	-> по умолчанию = 1
-m - множитель(увеличивает время работы не следующих шага) 	-> по умолчанию = 1
-help - помощь
-demo - демонстрация в укоренном режие
-exit - выход
````

## Примеры
````
-start
Старт Pomodoro
Work (25min) -- Break (5min) -- Long break (10min) -- Repeats = 1 
-------------------------------------------------------------------------------------------
#1  23:31:59 | Work(1min)       |   100% -> [ ######################################## ]
    23:56:59 | Break(1min)      |   100% -> [ ######################################## ]
-------------------------------------------------------------------------------------------
````

````
Пример 1 : 
-w 30 -b 5 -r 2
-start 
-> работа -30 мин; отдых -5; 2 повтора
длинный перерыв = 15(значение по умолчанию), если ранее не было услановлено другое значение
````
````
Пример 2 : -start
-> заапустится либо с параметрами по умолчани, либо с установленными(см. пример 1)
````
````
Пример 3:
  -start -w 20 -b 5 -l 10
-> работа -20 мин; отдых -5; длинный повтор - 10 ; 1 повтор(значение по умолчанию)   
````
````   
Пример 4 : -start -d    
    запустится выполнение помидора со значениями по умолчанию
````


![img.png](res/img.png)

## Запуск

    gradle build
    
    java -jar  build/libs/pomodoro.jar
