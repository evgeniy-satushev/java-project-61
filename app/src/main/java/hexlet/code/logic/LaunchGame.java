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
    LaunchGame() { }
    // список предлагаемых игр
    private static final List<String> GAMES = List.of("Greet", "Even", "Calc", "GCD", "Progression", "Prime", "Exit");

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
     * Принимает на вход число, выбранное пользователем,
     * и в зависимости от порядкового номера сопоставленного с игрой запускает определённый кейс.
     * @param choiceGame выбор пользователя.
     */
    private static void changeGame(int choiceGame) {
        switch (choiceGame) {
            case 0 -> { }
            case 1 -> Cli.greeting();
            case 2 -> {
                Even even = new Even(Cli.greeting(), 3);
                even.evenNumber();
            }
            case 3 -> {
                Calc calc = new Calc(Cli.greeting(), 3);
                calc.calc();
            }
            case 4 -> {
                Gcd gcd = new Gcd(Cli.greeting(), 3);
                gcd.greatestCommonDiv();
            }
            case 5 -> {
                Progression progression = new Progression(Cli.greeting(), 3);
                progression.progression();
            }
            case 6 -> {
                Prime prime = new Prime(Cli.greeting(), 3);
                prime.primeNumbers();
            }
            default -> System.out.println("!?");
        }
    }
}
