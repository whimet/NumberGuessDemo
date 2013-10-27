package demo;

public class NumberGuessGame {
    private String answer;
    private int retryCount;

    public NumberGuessGame(String answer) {
        if (answer.length() != 4) {
            throw new IllegalArgumentException("Invalid setup");
        }
        this.answer = answer;
    }

    public String input(String string) {
        retryCount++;

        if (string.length() != 4) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (retryCount == 6) {
            return "Game Over";
        } else if (answer.equals(string)) {
            return "You win";
        } else {
            return clueForInput(string);
        }
    }

    private String clueForInput(String string) {
        int numberOfA = 0;
        int numberOfB = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == answer.charAt(i)) {
                numberOfA++;
            } else if (answer.contains(Character.toString(string.charAt(i)))) {
                numberOfB++;
            }
        }
        return String.format("%dA%dB", numberOfA, numberOfB);
    }
}
