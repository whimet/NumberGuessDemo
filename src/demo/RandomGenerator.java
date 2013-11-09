package demo;

import java.util.Random;

public class RandomGenerator {

    private final Random random;
    private final int max;

    public RandomGenerator(int max) {
        random = new Random();
        this.max = max;
    }

    public int generate() {
        int i = random.nextInt();
        double d = i / (double) Integer.MAX_VALUE;
        double v = (d + 1) / 2;
        return (int) Math.ceil(v * max);
    }

    public String generateNumberString(int length) {
        StringBuilder builder = new StringBuilder();
        while (builder.length() < length) {
            int number = generate();
            if (builder.indexOf(String.valueOf(number)) < 0) {
                builder.append(number);
            }
        }
        return builder.toString();
    }
}
