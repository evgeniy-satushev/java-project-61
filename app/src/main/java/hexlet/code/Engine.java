package hexlet.code;

public interface Engine {
    String welcome();
    void description(String rules);
    String showWrongAnswer(String answer, int result, String userName);
    boolean exitGame(int correctAnswerCounter, String userName, boolean cycleOperation);
    int equalAnswer(String answer, String wrongAnswer, int result, int correctAnswerCounter);
    void showQuestion(String expression);
}
