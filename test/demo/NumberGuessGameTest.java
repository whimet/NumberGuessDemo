package demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NumberGuessGameTest {

    @Test
    public void should_return_you_win_if_user_given_the_right_number() {
        NumberGuessGame game = new NumberGuessGame("1234");
        String result = game.input("1234");
        assertEquals("You win", result);
    }

    @Test
    public void should_return_1A3B_if_user_guess_one_right_and_three_acceptable() {
        NumberGuessGame game = new NumberGuessGame("1234");
        String result = game.input("1423");
        assertEquals("1A3B", result);
    }

    @Test
    public void should_return_game_over_if_user_exceeds_six_tries() {
        NumberGuessGame game = new NumberGuessGame("1234");
        game.input("1423");
        game.input("1423");
        game.input("1423");
        game.input("1423");
        game.input("1423");
        String result = game.input("1423");
        assertEquals("Game Over", result);
    }

    @Test
    public void should_refuse_invalid_input() {
        NumberGuessGame game = new NumberGuessGame("1234");
        try {
            game.input("142");
            fail("should throw exception for invalid input");
        } catch (Exception e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }

    @Test
    public void should_refuse_invalid_game_setup() {
        try {
            new NumberGuessGame("123");
            fail("should throw exception for invalid setup");
        } catch (Exception e) {
            assertEquals("Invalid setup", e.getMessage());
        }
    }
}
