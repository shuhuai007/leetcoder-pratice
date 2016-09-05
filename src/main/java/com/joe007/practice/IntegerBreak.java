package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiezhou on 9/5/16.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        Map<Integer, Integer> integerBreakMap = new HashMap<Integer, Integer>();
        integerBreakMap.put(0, 0);
        integerBreakMap.put(1, 1);
        integerBreakMap.put(2, 1);
        return integerBreak(n , integerBreakMap);
    }

    private int integerBreak(int n, Map<Integer, Integer> integerBreakMap) {
        if (integerBreakMap.containsKey(n)) {
            return integerBreakMap.get(n);
        }

        int max = 1;
        for (int i = 2; i <= Math.ceil(((double)n) / 2); i++) {
            int firstPartMax = getMax(integerBreakMap, i);
            int secondPartMax = getMax(integerBreakMap, n - i);

            int newMax = firstPartMax * secondPartMax;
            if (newMax > max) {
                max = newMax;
            }
        }

        integerBreakMap.put(n, max);
        return max;
    }

    private int getMax(Map<Integer, Integer> integerBreakMap, int i) {
        int firstPartMax = integerBreak(i, integerBreakMap);
        if (firstPartMax < i) {
            firstPartMax = i;
        }
        return firstPartMax;
    }

}
