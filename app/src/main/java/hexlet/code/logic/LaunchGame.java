package hexlet.code.logic;

import hexlet.code.games.Cli;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс "Запуск Игры" отвечает за отображение игр,
 * а также их запуск при вводе пользователем номера варианта игры.
 */
public class LaunchGame {
    // количество раундов в игре.
    private static final int ROUNDS = 3;
    // список предлагаемых игр.
    private static final List<String> GAMES = List.of("Greet", "Even", "Calc", "GCD", "Progression", "Prime", "Exit");
    LaunchGame() { }
    /**
     * Предназначен для запуска и выбора игры под определённым номером,
     * при попытке ввести любое значение не определённое правилам выбора
     * произойдёт выход из игры.
     */
    public static void start() {
        displayGameNames();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("incorrect input vale, please enter the number");
        }
        changeGame(choice);
        sc.close();
    }

    /**
     * Вывод списка всех пронумерованных игр.
     */
    private static void displayGameNames() {
        List<String> numberedListOfGames = getNumberedListOfGames();
        System.out.println("Please enter the game number and press Enter");
        numberedListOfGames.forEach(System.out::println);
        System.out.print("Your choice: ");
    }

    /**
     * Утилитарный метод, форматирующий вывод списка всех игр,
     * добавляя напротив каждой игры порядковый номер.
     * @return список пронумерованных игр.
     */
    private static List<String> getNumberedListOfGames() {
        AtomicInteger counter = new AtomicInteger(1);
        return LaunchGame.GAMES.stream()
                .map(gameName -> {
                    if (counter.get() != GAMES.size()) {
                        return counter.getAndIncrement() + " - " + gameName;
                    }
                    return "0 - Exit";
                })
                .toList();
    }

    /**
     * Принимает на вход число выбранное пользователем,
     * и в зависимости от порядкового номера сопоставленного с игрой запускает определённый кейс.
     * @param choiceGame выбор пользователя.
     */
    private static void changeGame(int choiceGame) {
        Numbers choice = getNumber(choiceGame);
        switch (choice) {
            case ZERO -> { }
            case ONE -> Cli.greeting();
            case TWO -> {
                Even even = new Even(Cli.greeting(), ROUNDS);
                even.evenNumber();
            }
            case THREE -> {
                Calc calc = new Calc(Cli.greeting(), ROUNDS);
                calc.calc();
            }
            case FOUR -> {
                Gcd gcd = new Gcd(Cli.greeting(), ROUNDS);
                gcd.greatestCommonDiv();
            }
            case FIVE -> {
                Progression progression = new Progression(Cli.greeting(), ROUNDS);
                progression.progression();
            }
            case SIX -> {
                Prime prime = new Prime(Cli.greeting(), ROUNDS);
                prime.primeNumbers();
            }
            default -> System.out.println("!?");
        }
    }

    /**
     * Преобразует из целочисленного числа в объект перечисления.
     * @param choice целое число.
     * @return объект перечисление сопоставленный сопоставленный с входящим числом,
     * если числа нету списке объекта "Перечисления", то вернётся ноль.
     */
    private static Numbers getNumber(int choice) {
        List<Numbers> numbers = Numbers.getAll();
        for (Numbers number : numbers) {
            if (number.getValue() == choice) {
                return number;
            }
        }
        return Numbers.ZERO;
    }
}
