package com.joe007.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * @author zhoujie
 * Start Time : 2013/11/11 : 16:24
 * End   Time : 2013/11/11 : 
 */
public class FourSum {
	
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length < 4 || (num.length == 4 && sum(num) != target)){
			return resultList;
		}
		
		if(num.length == 4 && sum(num) == target){
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for(int element : num){
				tempList.add(element);
			}
			Collections.sort(tempList);
			resultList.add(tempList);
			return resultList;
		}
		
		resultList = xSum(num, 4, target);
		return resultList;
	}

	
	private ArrayList<ArrayList<Integer>> xSum(int[] num, int count, int target) {
//		System.out.println("xSum" + "; count:"  + count + "; target:" + target);
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0 || num.length < count || (num.length == count && sum(num) != target)){
			return resultList;
		}
		
		if(num.length == count && sum(num) == target){
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for(int element : num){
				tempList.add(element);
			}
			Collections.sort(tempList);
			resultList.add(tempList);
			return resultList;
		}
		
		
		int[] leftArr = Arrays.copyOfRange(num, 0, num.length/2);
		int[] rightArr = Arrays.copyOfRange(num, num.length/2, num.length);
//		System.out.println("leftArr size:" + leftArr.length + "; rightArr's size:" + rightArr.length);
		for(int i = 0; i <= count; i++){
			int leftCount = i;
			int rightCount = count - i;
//			System.out.println("leftCount: " + leftCount + "; rightCount:" + rightCount);
			if(leftCount == 0){
				ArrayList<ArrayList<Integer>> rightResultList = xSum(rightArr, count, target);
				resultList.addAll(rightResultList);
			} else if(rightCount == 0){
				ArrayList<ArrayList<Integer>> leftResultList = xSum(leftArr, count, target);
				resultList.addAll(leftResultList);
//				if(!resultList.contains(rightList)){
//					resultList.add(rightList);
//				}
			} else {
//				System.out.println("======before map, leftCount:" + leftCount + ";leftArr: " );
				Map<Integer, ArrayList<ArrayList<Integer>>> map = combination(leftArr, leftCount);
//				System.out.println("======map:" + map);
				for(int key : map.keySet()){
					ArrayList<ArrayList<Integer>> values = map.get(key);
					ArrayList<ArrayList<Integer>> rightResultList = xSum(rightArr, rightCount, target - key);
					for(ArrayList<Integer> rightList : rightResultList){
						for(ArrayList<Integer> value : values){
							rightList.addAll(value);
							if(!resultList.contains(rightList)){
								resultList.add(rightList);
							}
						}
					}
				}
			}
//			System.out.println("----resultList:" + resultList);
		}
		
		return resultList;
	}


	private Map<Integer, ArrayList<ArrayList<Integer>>> combination(int[] leftArr, int leftCount) {
		Map<Integer, ArrayList<ArrayList<Integer>>> resultMap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
		if(leftCount <= 0){
			return resultMap;
		}
		if(leftCount == 1){
			for(int elem : leftArr){
				ArrayList<ArrayList<Integer>> lists = null;
				if(resultMap.containsKey(elem)){
					lists = resultMap.get(elem);
				} else {
					lists = new ArrayList<ArrayList<Integer>>();
				}
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(elem);
				lists.add(list);
				resultMap.put(elem, lists);
			}
			return resultMap;
		}
		
		int count = leftCount - 1;
		Map<Integer, ArrayList<ArrayList<Integer>>> subResultMap = combination(leftArr, count);
		ArrayList<ArrayList<Integer>> newLists = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<ArrayList<Integer>> lists : subResultMap.values()){
			newLists.addAll(lists);
		}
//		System.out.println("````````````````newLists:" + newLists);
		
		for(int i = 0; i < newLists.size(); i++){
			ArrayList<Integer> iList = newLists.get(i);
			int iSum = sum(iList);
			for(int j = i + 1; j < newLists.size(); j++){
				ArrayList<Integer> jList = newLists.get(j);
				for(int elem : jList){
					int ijSum = iSum + elem;
					ArrayList<Integer> ijList = new ArrayList<Integer>(iList);
					ArrayList<ArrayList<Integer>> ijLists = null;
					if(resultMap.containsKey(ijSum)){
						ijLists = resultMap.get(ijSum);
					} else {
						ijLists = new ArrayList<ArrayList<Integer>>();
						resultMap.put(ijSum, ijLists);
					}
					ijList.add(elem);
					Collections.sort(ijList);
//					System.out.println("````````````````i:" + i + "; j:" + j + "; ijList" + ijList);
					if(!ijLists.contains(ijList)){
						ijLists.add(ijList);
					}
				}
				
			}
		}

		return resultMap;
	}


	private int sum(int[] num) {
		int sum = 0;
		for(int i = 0; i < num.length; i++){
			sum += num[i];
		}
		return sum;
	}
	
	private int sum(List<Integer> list) {
		int sum = 0;
		for(int elem : list){
			sum += elem;
		}
		return sum;
	}

	public static void main(String[] args) {
		FourSum instance = new FourSum();
		
		int [] num = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(instance.fourSum(num, target));
	}

}
