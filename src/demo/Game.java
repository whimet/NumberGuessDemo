package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private NumberGuess numberGuess;

    public Game(RandomNumberGenerator generator) {
        String answer = generator.generate();
        numberGuess = new NumberGuess(answer);
    }

    public String input(String string) {
        return numberGuess.input(string);
    }

    public static void main(String[] args) throws IOException {
        RandomNumberGenerator generator =
                new RandomNumberGenerator(new RandomGenerator(5));
        Game game = new Game(generator);
        System.out.println("Give your input:");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        boolean run = true;
        do {
            String string = reader.readLine();
            String output = game.input(string);
            System.out.println(output);

            if (!output.equals("You win") && !output.equals("Game Over")) {
                System.out.println("Try again:");
            } else {
                run = false;
            }
        } while (run);
    }
}
