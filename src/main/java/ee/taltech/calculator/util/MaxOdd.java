package ee.taltech.calculator.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class MaxOdd {
    public static Integer getResult(List<Integer> params) {
        if(CollectionUtils.isEmpty(params)){ return null;}
        return params.stream().filter(x -> x % 2 == 1 || x % 2 == -1).max(Integer::compare).orElse(null);
    }
}