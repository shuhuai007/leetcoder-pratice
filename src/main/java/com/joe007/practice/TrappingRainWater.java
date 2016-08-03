package com.joe007.practice;


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * @author zhoujie
 *
 * Start Time : 2013/10/25 : 16:56
 * End   Time : 2013/10/25 : 
 */
public class TrappingRainWater {

    public int trap(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }

        int totalRainWater = 0;
        int currentPos = 1;
        int beginIndex = -1;
        int endIndex = -1;
        
        
        while(currentPos < A.length){
            if(A[currentPos] > A[currentPos - 1]){
                if(beginIndex == -1){
                    // do nothing
                } else {
                    endIndex = currentPos;
                }
            } else if(A[currentPos] < A[currentPos - 1]) {
                if(beginIndex == -1){
                    // new begin
                    beginIndex = currentPos - 1;
                    endIndex = -1;
                } else {
                    
                    // end the last one ,and begin the new one
                    int rainWater = computeRainWater(A, beginIndex, endIndex);
                    totalRainWater += rainWater;
                    beginIndex = currentPos - 1;
                    endIndex = -1;
                }
            } else {
                // do nothing
            }
        }
        
        return  totalRainWater;
    }

    private int computeRainWater(int[] a, int beginIndex, int endIndex) {
        int height = Math.min(a[beginIndex], a[endIndex]);
//        int width = 
        return 0;
    }

    public static void main(String[] args) {
        TrappingRainWater instance = new TrappingRainWater();

        int[] A = {};
        System.out.println(instance.trap(A));
    }

}
