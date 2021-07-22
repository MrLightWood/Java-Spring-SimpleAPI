package ee.taltech.calculator.utils;

import ee.taltech.calculator.util.MaxOdd;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxOddTest {
    @Test
    void empty_list() {
        assertEquals(null, MaxOdd.getResult(List.of()));
        assertEquals(null, MaxOdd.getResult(null));
    }

    @Test
    void no_odds() {
        assertEquals(null, MaxOdd.getResult(List.of(0,2,4,8,10)));
    }

    @Test
    void no_evens() {
        assertEquals(9, MaxOdd.getResult(List.of(1,3,5,7,9)));
    }

    @Test
    void odd_and_evens() {
        assertEquals(11, MaxOdd.getResult(List.of(0,1,2,3,4,5,6,7,8,9,11)));
    }

    @Test
    void negative_odd() {
        assertEquals(-5, MaxOdd.getResult(List.of(-9,-7,-5,-8,-10)));
    }
}
