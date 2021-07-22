package ee.taltech.calculator.util;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;


public class AverageOfNegatives {
    public static Double getResult(List<Integer> params) {
        if(CollectionUtils.isEmpty(params)){ return null;}
        Double result = params.stream().filter(x -> x < 0).collect(Collectors.averagingDouble(Integer::doubleValue));
        return Math.round(result*100.0)/100.0;
    }
}
