package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author zhoujie
 *
 * Start Time : 2013/10/23 : 19:09
 * End   Time : 2013/10/23 : 19:37
 */
public class ThreeSumClosest {
    
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3){
            return 0;
        }

        int margin = Integer.MAX_VALUE;
        int finalSum = 0;
        for (int i = 0; i < num.length - 1; i++) {
            for(int j = i + 1; j <= num.length - 1; j++){
                for(int k = j + 1; k <= num.length - 1; k++){
                    int sum = num[i] + num[j] + num[k];
                    int absSum = Math.abs(sum - target);
                    if(absSum < margin){
                        margin = absSum;
                        finalSum = sum;
                    }
                }
            }
        }

        return finalSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest instance = new ThreeSumClosest();
        int [] num = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(instance.threeSumClosest(num, target));
        
    }

}
