package ee.taltech.calculator.utils;

import ee.taltech.calculator.util.Odds;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddsTest {
    @Test
     void only_evens(){
        assertEquals(null, Odds.getResult(List.of(0,2,4,8,10)));
    }
    @Test
    void only_odds(){
        assertEquals(List.of(1,3,5,9), Odds.getResult(List.of(1,3,5,9)));
    }
    @Test
    void mixed(){
        assertEquals(List.of(7,9), Odds.getResult(List.of(0,2,7,8,9,12)));
    }
    @Test
    void negatives(){
        assertEquals(List.of(11,-13), Odds.getResult(List.of(-2,4,-8,11,-13)));
    }
}
