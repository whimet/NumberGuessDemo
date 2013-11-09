package demo;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomGeneratorTest {

    private RandomGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new RandomGenerator(5);
    }

    @Test
    public void should_generate_number_string_with_specified_length() {
        String numberString = generator.generateNumberString(4);
        assertEquals(4, numberString.length());
    }

    @Test
    public void should_generate_number_string_consist_of_valid_numbers() {
        String numberString = generator.generateNumberString(4);
        for (int i = 0; i < numberString.length(); i++) {
            char c = numberString.charAt(i);
            int number = Integer.parseInt(Character.toString(c));
            assertTrue(number >= 1 && number <= 5);
        }
    }

    @Test
    public void should_generate_number_string_with_no_duplicated_number() {
        String numberString = generator.generateNumberString(4);
        HashSet<Character> characters = new HashSet<Character>();
        for (int i = 0; i < numberString.length(); i++) {
            characters.add(numberString.charAt(i));
        }
        assertEquals(4, characters.size());
    }

}
