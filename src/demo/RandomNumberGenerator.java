package demo;

public class RandomNumberGenerator {
    private RandomGenerator generator;

    public RandomNumberGenerator(RandomGenerator generator) {
        this.generator = generator;
    }

    public String generate() {
        StringBuilder builder = new StringBuilder();
        while(builder.length() < 4) {
            int number = generator.generate();
            if (builder.indexOf(String.valueOf(number)) < 0) {
                builder.append(number);
            }
        }
        return builder.toString();
    }
}
