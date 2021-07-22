package ee.taltech.calculator.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Calculation2Result {
    private Integer sumOfEvenResult;
    private List<Integer> powerOf4Result;
    private Double averageOfNegativesResult;
}
