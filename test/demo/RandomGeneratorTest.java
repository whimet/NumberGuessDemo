package demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class RandomGeneratorTest {

    @Test
    public void max_variance_should_be_less_than_dot_five_percentage() {
        RandomGenerator generator = new RandomGenerator(5);
        Double max = maxVarianceInRounds(generator, 100);
        assertTrue(max < 0.5d);
    }

    private static Double maxVarianceInRounds(RandomGenerator generator, int rounds) {
        ArrayList<Double> variances = new ArrayList<Double>();
        for (int i = 0; i < rounds; i++) {
            variances.add(runOnce(generator, 1000000));
        }
        Collections.sort(variances);

        return variances.get(variances.size() - 1);
    }

    private static Double runOnce(RandomGenerator generator, int rounds) {
        int[] counts = {0, 0, 0, 0, 0};
        for (int i = 0; i < rounds; i++) {
            int number = generator.generate();
            counts[number - 1] = counts[number - 1] + 1;
        }

        double[] percentages = {0, 0, 0, 0, 0};
        for (int i = 0; i < counts.length; i++) {
            percentages[i] = counts[i] / (double) rounds;
        }

        ArrayList<Double> variances = new ArrayList<Double>();
        for (int i = 0; i < percentages.length; i++) {
            for (int j = i + 1; j < percentages.length; j++) {
                variances.add(100 * Math.abs(percentages[i] - percentages[j]));
            }
        }
        Collections.sort(variances);

//        HashMap<Integer, Double> result = new HashMap<Integer, Double>();
//        for (int i = 0; i < percentages.length; i++) {
//            result.put(i + 1, percentages[i]);
//        }
//        System.out.println(result);
        return variances.get(variances.size() - 1);
    }

}
