package com.joe007.practice;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author zhoujie
 * 
 * Start Time : 2013/10/10 : 14:30
 * End   Time : 2013/10/10 : 15:13
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n <= 0){
            return 0;
        }
        if(1 == n){
            return 1;
        }
        int numberOfStep2Min = 0;
        int numberOfStep2Max = n/2;
        int totalMethods = 0;
        for (int i = numberOfStep2Min; i <= numberOfStep2Max; i++) {
            int tempMethod = computeCombinationNum(n-i, i);
//            System.out.println("i:" + i + "; " + "n-i:" + (n-i) + "; " + "tempMethod:" + tempMethod);
            totalMethods += tempMethod;
        }

        return totalMethods;
    }

    private int computeCombinationNum(int totalN, int i) {
        int remainI = totalN - i;
        if(remainI < i){
            i = remainI;
        }
        double tempMethod = 1;
        // (n-i)*(n-i-1)...(n-2i+1)
        for(int j = 0; j <= i-1; j++ ){
            tempMethod *= (double)(totalN-j);
            tempMethod /= (double)(j + 1);
        }

        return (int)tempMethod;
    }

    public static void main(String[] args) {
        ClimbingStairs instance = new ClimbingStairs();
        System.out.println(instance.climbStairs(35));

    }

}
