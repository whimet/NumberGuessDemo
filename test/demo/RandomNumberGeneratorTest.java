package demo;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class RandomNumberGeneratorTest {

    @Test
    public void should_generate_number_with_length_4() {
        RandomGenerator generator = new RandomGenerator(5);
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator(generator);
        String number = numberGenerator.generate();
        assertEquals(4, number.length());
    }

    @Test
    public void should_generate_number_consist_of_valid_numbers() {
        RandomGenerator generator = new RandomGenerator(5);
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator(generator);
        String number = numberGenerator.generate();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            String s = String.valueOf(c);
            int integer = Integer.parseInt(s);
            assertTrue(integer >= 1 && integer <= 5);
        }
    }

    @Test
    public void should_not_generate_duplicated_number() {
        RandomGenerator mock = new MockRandomNumberGenerator("12134");
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator(mock);

        String numbers = numberGenerator.generate();
        assertEquals("1234", numbers);
    }

    private static class MockRandomNumberGenerator
            extends RandomGenerator {

        private String expected;
        private int count;

        public MockRandomNumberGenerator(String expectedNumbers) {
            super(5);
            this.expected = expectedNumbers;
        }

        @Override
        public int generate() {
            char c = expected.charAt(count);
            int result = Integer.parseInt(String.valueOf(c));
            count++;
            return result;
        }
    }
}
