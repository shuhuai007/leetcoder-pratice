package com.joe007.practice;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/15 : 10:11
 * End   Time : 2013/10/15 : 10:41
 *
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if(height == null){
            return 0;
        }
        if(height.length == 0){
            return 0;
        }
        int maxArea = 0;
        int beginIndex = 0;
        int endIndex = height.length - 1;
        while(beginIndex < endIndex){
            int area = (endIndex - beginIndex) * Math.min(height[beginIndex], height[endIndex]);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[beginIndex] > height[endIndex]){
                endIndex--;
            } else {
                beginIndex++;
            }
        }

        return maxArea;
    }

//    public int maxArea(int[] height) {
//        if(height == null){
//            return 0;
//        }
//        if(height.length == 0){
//            return 0;
//        }
//        int maxArea = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j - i) * Math.min(height[i], height[j]);
//                if(area > maxArea){
//                    maxArea = area;
//                }
//            }
//        }
//        
//        return maxArea;
//    }

    public static void main(String[] args) {
        ContainerWithMostWater instance = new ContainerWithMostWater();
//        int[] height = {};
        int[] height = {1, 2};
        System.out.println(instance.maxArea(height));

    }

}
