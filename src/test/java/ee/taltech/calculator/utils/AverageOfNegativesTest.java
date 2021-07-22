package ee.taltech.calculator.utils;

import ee.taltech.calculator.util.AverageOfNegatives;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AverageOfNegativesTest {
    @Test
    void empty_list() {
        assertEquals(null, AverageOfNegatives.getResult(List.of()));
        assertEquals(null, AverageOfNegatives.getResult(null));
    }

    @Test
    void only_positives() {
        assertEquals(0.0, AverageOfNegatives.getResult(List.of(0,2,4,8,10)));
    }

    @Test
    void only_negatives() {
        assertEquals(-4.2, AverageOfNegatives.getResult(List.of(-1,-2,-3,-5,-10)));
    }

    @Test
    void positives_and_negatives() {
        assertEquals(-28.0, AverageOfNegatives.getResult(List.of(1,-5,9,-10,7,-69)));
    }
}
