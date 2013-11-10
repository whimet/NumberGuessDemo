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
        int integer = random.nextInt();
        double decimal = integer / (double) Integer.MAX_VALUE;
        double positiveDecimal = (decimal + 1) / 2;
        return (int) Math.ceil(positiveDecimal * max);
    }

}
