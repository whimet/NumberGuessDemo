package demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GameTest {

    private RandomNumberGenerator mock;

    @Before
    public void setUp() {
        mock = Mockito.mock(RandomNumberGenerator.class);
    }

    @Test
    public void should_return_you_win_if_user_gives_the_right_number() {
        when(mock.generate()).thenReturn("1234");
        Game game = new Game(mock);

        String output = game.input("1234");

        assertEquals("You win", output);
    }
}
