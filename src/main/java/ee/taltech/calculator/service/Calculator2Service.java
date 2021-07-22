package ee.taltech.calculator.service;

import ee.taltech.calculator.DTO.Calculation2Result;
import ee.taltech.calculator.util.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Calculator2Service {
    public Calculation2Result calculate(List<Integer> input) {
        Calculation2Result result = new Calculation2Result();
        result.setPowerOf4Result(PowerOf4.getResult(input));
        result.setAverageOfNegativesResult(AverageOfNegatives.getResult(input));
        result.setSumOfEvenResult(SumOfEven.getResult(input));
        return result;
    }
}
