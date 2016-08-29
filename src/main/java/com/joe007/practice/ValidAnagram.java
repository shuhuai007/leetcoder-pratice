package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiezhou on 8/23/16.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> sMap = generateChar2CountMap(s);
        Map<Character, Integer> tMap = generateChar2CountMap(t);
        if (sMap.keySet().size() != tMap.keySet().size()) {
            return false;
        }
        for (Character character : sMap.keySet()) {
            if (!tMap.containsKey(character)) {
                return false;
            }

            int sCount = sMap.get(character);
            int tCount = tMap.get(character);
            if (sCount != tCount) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> generateChar2CountMap(String s) {
        Map<Character, Integer> char2CountMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            int count = 1;
            if (char2CountMap.containsKey(element)) {
                int oldCount = char2CountMap.get(element);
                count = oldCount + 1;
            }
            char2CountMap.put(element, count);
        }
        return char2CountMap;
    }
}
