package ee.taltech.calculator.utils;

import ee.taltech.calculator.util.PowerOf4;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOf4Test {
    @Test
    void empty_list() {
        assertEquals(null, PowerOf4.getResult(List.of()));
        assertEquals(null, PowerOf4.getResult(null));
    }

    @Test
    void all_positives() {
        assertEquals(List.of(1, 16, 81), PowerOf4.getResult(List.of(1, 2, 3)));
    }

    @Test
    void all_negatives() {
        assertEquals(List.of(1, 16, 81), PowerOf4.getResult(List.of(-1, -2, -3)));
    }

    @Test
    void positives_and_negatives() {
        assertEquals(List.of(1, 16, 81, 256), PowerOf4.getResult(List.of(-1,2,-3,4)));
    }
}
