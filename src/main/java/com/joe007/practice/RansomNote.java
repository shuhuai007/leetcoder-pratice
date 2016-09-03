package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiezhou on 8/15/16.
 */
public class RansomNote {

    /**
     * Checks if the ransom can be constructed from magazine.
     *
     * @param ransomNote ransomNote str
     * @param magazine magazine str
     * @return true if the ransom can be constructed from magazine
     */
    public boolean canConstruct(String ransomNote, String magazine) {
//        if (ransomNote == null || ransomNote.isEmpty()) {
//            return true;
//        }
//        if (magazine == null || magazine.isEmpty()) {
//            return false;
//        }
//        char firstChar = ransomNote.charAt(0);
//        int midIndex = getMiddleIndex(magazine);
//        if (firstChar == magazine.charAt(midIndex)) {
//            return canConstruct(ransomNote.substring(1), magazine.substring(0, midIndex))
//                    || canConstruct(ransomNote.substring(1), magazine.substring(midIndex + 1));
//        } else {
//            return canConstruct(ransomNote, )
//        }

        Map<Character, Integer> char2CountMap = new HashMap<Character, Integer>();
        for (char magazineChar : magazine.toCharArray()) {
            int count = 1;
            if (char2CountMap.containsKey(magazineChar)) {
                count = char2CountMap.get(magazineChar) + 1;
            }
            char2CountMap.put(magazineChar, count);
        }

        for (char ransomChar : ransomNote.toCharArray()) {
            if (!char2CountMap.containsKey(ransomChar)) {
                return false;
            }
            int count = char2CountMap.get(ransomChar);
            if (count <= 0) {
                return false;
            }

            char2CountMap.put(ransomChar, --count);
        }

        return true;
    }

    private int getMiddleIndex(String magazine) {
        if (magazine.length() % 2 == 0) {
            return magazine.length() / 2 - 1;
        } else {
            return magazine.length() / 2;
        }
    }
}
