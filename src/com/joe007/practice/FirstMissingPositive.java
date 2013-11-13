package com.joe007.practice;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

3, 4, 1, 5,8,7,2

Your algorithm should run in O(n) time and uses constant space.
 * @author zhoujie
 * Start Time : 2013/11/12 : 20:35
 * End   Time : 2013/11/13 : 14:08
 *
 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		if(A == null || A.length == 0){
			return 1;
		}
		
		int[] indexArr = findMinConsecutiveSection(A);
		int minBeginVal = indexArr[0];
		int minEndVal = indexArr[1];
//		System.out.println("minBeginVal:" + minBeginVal);
		if(minBeginVal != 1){
			return 1;
		} else {
			return minEndVal + 1;
		}
	}

	private int[] findMinConsecutiveSection(int[] A) {
		
		int[] resultArr = new int[4];
		for(int i = 0; i < 4; i++){
			resultArr[i] = Integer.MAX_VALUE;
		}
		
		if(A.length == 1){
			if(A[0] > 0){
				resultArr[0] = A[0];
				resultArr[1] = A[0];
			}
			return resultArr;
		}
		
		int currentVal = A[A.length - 1];
		
		int[] subResultArr = findMinConsecutiveSection(Arrays.copyOfRange(A, 0, A.length - 1));
		if(currentVal <= 0){
			return subResultArr;
		}
		
		printArr(subResultArr);
		
		if(subResultArr[0] == Integer.MAX_VALUE){
			resultArr[0] = currentVal;
			resultArr[1] = currentVal;
			return resultArr;
		}
		
		if(subResultArr[2] == Integer.MAX_VALUE){
			// only min arr exists
			int beginVal = subResultArr[0];
			int endVal = subResultArr[1];
//			System.out.println("beginVal:" + beginVal + "; endVal:" + endVal);
			if(currentVal <= endVal && currentVal >= beginVal){
				// do nothing
			} else if(currentVal == beginVal - 1){
				// 
				subResultArr[0] = currentVal;
			} else if(currentVal < beginVal - 1){
				subResultArr[2] = subResultArr[0];
				subResultArr[3] = subResultArr[1];
				subResultArr[0] = currentVal;
				subResultArr[1] = currentVal;
			} else if(currentVal == endVal + 1){
				subResultArr[1] = currentVal;
			} else if(currentVal > endVal + 1){
				// 
				subResultArr[2] = currentVal;
				subResultArr[3] = currentVal;
			}
		} else {
			// both min arr and second min arr exist
			int minBeginVal = subResultArr[0];
			int minEndVal = subResultArr[1];
			int secondMinBeginVal = subResultArr[2];
			int secondMinEndVal = subResultArr[3];
			
			if((currentVal >= minBeginVal && currentVal <= minEndVal ) || (currentVal >= secondMinBeginVal && currentVal <= secondMinEndVal)){
				// nothing
			} else if(currentVal < minBeginVal - 1){
				subResultArr[2] = subResultArr[0];
				subResultArr[3] = subResultArr[1];
				subResultArr[0] = currentVal;
				subResultArr[1] = currentVal;
			} else if(currentVal == minBeginVal - 1){
				subResultArr[0] = currentVal;
			} else if(currentVal >minEndVal && currentVal < secondMinBeginVal){
				if((minEndVal + 1) == (secondMinBeginVal - 1)){
					// merge the tow Arr
					subResultArr[1] = subResultArr[3];
					subResultArr[2] = Integer.MAX_VALUE;
					subResultArr[3] = Integer.MAX_VALUE;
				} else {
					// 
					if(currentVal == minEndVal + 1){
						subResultArr[1] = currentVal;
					} else if(currentVal == secondMinBeginVal - 1){
						subResultArr[2] = currentVal;
					} else {
						subResultArr[2] = currentVal;
						subResultArr[3] = currentVal;
					}
				}
				
			} else if(currentVal == secondMinEndVal + 1){
				// 
				subResultArr[3] = currentVal;
			} else if(currentVal > secondMinEndVal + 1){
				// nothing to do
			}
			
		}
		return subResultArr;
	}

	private void printArr(int[] resultArr) {
		StringBuilder sb = new StringBuilder();
		for(int i : resultArr){
			sb.append(i).append(",");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		FirstMissingPositive instance = new FirstMissingPositive();
		int [] A = {41,16,65,7,56,5,64,14,67,2,3,20,-10,25,-8,10,2,59,9,6,43,4,22,50,41,37,5,21,-2,34,34,60,22,6,4,27,1,61,45,38,31,62,63,-10,4,60,21,4,4,33,40,26,16,34,51,1,5,10,20,-1,54,44,3,21,63,40,4,4};
//		int [] A = {3,4,-1,1};
		System.out.println(instance.firstMissingPositive(A));
	}

}
