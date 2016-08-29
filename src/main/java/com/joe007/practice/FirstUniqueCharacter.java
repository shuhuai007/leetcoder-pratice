package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiezhou on 8/29/16.
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        if (s == null || s.trim().length() == 0) {
            return -1;
        }

        Map<Character, Integer> char2CountMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            int count = 1;
            if (char2CountMap.containsKey(element)) {
                count = char2CountMap.get(element) + 1;
            }
            char2CountMap.put(element, count);
        }

        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            int count = char2CountMap.get(element);
            if (count == 1) {
                return i;
            }
        }

        return -1;
    }
}
