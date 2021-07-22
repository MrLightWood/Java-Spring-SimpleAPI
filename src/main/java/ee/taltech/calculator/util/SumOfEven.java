package ee.taltech.calculator.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class SumOfEven {
    public static Integer getResult(List<Integer> params) {
        if(CollectionUtils.isEmpty(params)){ return null;}
        return params.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum();
    }
}