package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiezhou on 8/31/16.
 */
public class FindDifference {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> char2CountMap = new HashMap<Character, Integer>();
        for (char character : s.toCharArray()) {
            int count = 1;
            if (char2CountMap.containsKey(character)) {
                count += char2CountMap.get(character);
            }
            char2CountMap.put(character, count);
        }

        for (char tChar : t.toCharArray()) {
            if (!char2CountMap.containsKey(tChar)) {
                return tChar;
            }
            int count = char2CountMap.get(tChar);
            if (count == 0) {
                return tChar;
            }
            char2CountMap.put(tChar, --count);
        }

        return 0;
    }
}
