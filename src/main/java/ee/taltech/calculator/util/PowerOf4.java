package ee.taltech.calculator.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PowerOf4 {
    public static List<Integer> getResult(List<Integer> params) {
        if(CollectionUtils.isEmpty(params)){ return null;}
        List<Integer> result = params.stream().map(integer -> (int) Math.pow((double) integer, 4)).collect(Collectors.toList());
        return result.isEmpty() ? null : result;
    }
}