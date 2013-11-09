package demo;

public class NumberGuess {
    private String answer;
    private int retryCount;

    public NumberGuess(String answer) {
        if (answer.length() < 4) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.answer = answer;
    }

    public String input(String string) {
        if (string.length() != answer.length()) {
            throw new IllegalArgumentException("Invalid input");
        }

        retryCount++;

        if (string.equals(answer)) {
            return "You win";
        }

        if (retryCount > 6) {
            return "Game Over";
        }

        return clueForInput(string);
    }

    private String clueForInput(String string) {
        int numberOfA = 0;
        int numberOfB = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (string.charAt(i) == answer.charAt(i)) {
                numberOfA++;
            } else if (answer.contains(
                    Character.toString(string.charAt(i)))) {
                numberOfB++;
            }
        }
        return numberOfA + "A" + numberOfB + "B";
    }
}
