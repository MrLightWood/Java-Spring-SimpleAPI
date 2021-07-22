package ee.taltech.calculator.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Odds {
    public static List<Integer> getResult(List<Integer> params) {
        if(CollectionUtils.isEmpty(params)){ return null;}
        List<Integer> result = params.stream().filter(x -> x % 2 == 1 || x % 2 == -1).collect(Collectors.toList());
        return result.isEmpty() ? null : result;
    }
}