package com.joe007.practice;

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
        if (ransomNote == null || ransomNote.isEmpty()) {
            return true;
        }
        if (magazine == null || magazine.isEmpty()) {
            return false;
        }
        char firstChar = ransomNote.charAt(0);
        int midIndex = getMiddleIndex(magazine);
        if (firstChar == magazine.charAt(midIndex)) {
            return canConstruct(ransomNote.substring(1), magazine.substring(0, midIndex))
                    || canConstruct(ransomNote.substring(1), magazine.substring(midIndex + 1));
        } else {
            return canConstruct(ransomNote, )
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
