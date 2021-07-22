package ee.taltech.calculator.utils;

import ee.taltech.calculator.util.SumOfEven;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfEvenTest {
    @Test
    void empty_list() {
        assertEquals(null, SumOfEven.getResult(List.of()));
        assertEquals(null, SumOfEven.getResult(null));
    }

    @Test
    void sum() {
        assertEquals(24, SumOfEven.getResult(List.of(0,2,4,8,10)));
    }

    @Test
    void no_evens() {
        assertEquals(0, SumOfEven.getResult(List.of(1,3,5,7,9)));
    }

    @Test
    void sum_with_negatives() {
        assertEquals(12, SumOfEven.getResult(List.of(0,1,2,3,4,5,6,-11)));
    }
}
