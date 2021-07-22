package ee.taltech.calculator.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Calculation1Result {
    private Integer sumOfEvenResult;
    private Integer maxOddResult;
    private List<Integer> oddsResult;
}
