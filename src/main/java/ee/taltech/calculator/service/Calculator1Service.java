package ee.taltech.calculator.service;

import ee.taltech.calculator.DTO.Calculation1Result;
import ee.taltech.calculator.util.MaxOdd;
import ee.taltech.calculator.util.Odds;
import ee.taltech.calculator.util.SumOfEven;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Calculator1Service {
    public Calculation1Result calculate(List<Integer> input) {
        Calculation1Result result = new Calculation1Result();
        result.setOddsResult(Odds.getResult(input));
        result.setMaxOddResult(MaxOdd.getResult(input));
        result.setSumOfEvenResult(SumOfEven.getResult(input));
        return result;
    }
}
