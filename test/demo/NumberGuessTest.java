package demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NumberGuessTest {

    @Test
    public void should_return_you_win_if_user_gives_the_right_number() {
        NumberGuess numberGuess = new NumberGuess("1234");
        String output = numberGuess.input("1234");
        assertEquals("You win", output);
    }

    @Test
    public void should_return_1A3B_if_partially_correct() {
        NumberGuess numberGuess = new NumberGuess("1234");
        String output = numberGuess.input("1342");
        assertEquals("1A3B", output);
    }

    @Test
    public void should_return_game_over_if_user_exceeds_six_tries() {
        NumberGuess numberGuess = new NumberGuess("1234");
        numberGuess.input("4321");
        numberGuess.input("4321");
        numberGuess.input("4321");
        numberGuess.input("4321");
        numberGuess.input("4321");
        numberGuess.input("4321");
        String output = numberGuess.input("4321");
        assertEquals("Game Over", output);
    }

    @Test
    public void should_return_you_win_if_user_gives_right_number_at_last_time() {
        NumberGuess numberGuess = new NumberGuess("1234");
        numberGuess.input("4321");
        numberGuess.input("4321");
        numberGuess.input("4321");
        numberGuess.input("4321");
        numberGuess.input("4321");
        numberGuess.input("4321");
        String output = numberGuess.input("1234");
        assertEquals("You win", output);
    }

    @Test
    public void should_refuse_invalid_input() {
        NumberGuess numberGuess = new NumberGuess("1234");
        try {
            numberGuess.input("123");
            fail("should throw exception for invalid input");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }

    @Test
    public void should_refuse_invalid_creation() {
        try {
            new NumberGuess("12");
            fail("should throw exception for invalid input");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }

}
