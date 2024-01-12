package hexlet.code;

import hexlet.code.logic.LaunchGame;

/**
 * Класс Приложение предназначен исключительно для запуска игры.
 */
public class App {
    App() { }

    /**
     * Точка входа в игру.
     * @param args аргументы метода main
     */
    public static void main(String[] args) {
        LaunchGame.start();
    }
}
