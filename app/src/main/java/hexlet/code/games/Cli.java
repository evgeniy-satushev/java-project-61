package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс "Интерфейс командной строки" предназначен только для вывода приветствия.
 */
public class Cli {
    Cli() { }

    /**
     * Метод считывает имя пользователя и выводит на экран приветствие.
     * @return имя пользователя (игрока).
     */
    public static String greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = scanner.nextLine();
        System.out.printf("Hello, %s!\n", userName);
        return userName;
    }
}
