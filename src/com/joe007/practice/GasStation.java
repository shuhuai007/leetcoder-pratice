package com.joe007.practice;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 * @author zhoujie
 * 
 * Start Time : 2013/11/07 : 19:00
 * End   Time : 2013/11/07 : 20:55
 *
 */
public class GasStation {

//	public int canCompleteCircuit(int[] gas, int[] cost) {
//		if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
//			return -1;
//		}
//
//		for (int i = 0; i < gas.length;) {
//			System.out.println("i:" + i);
//			if(gas[i] < cost[i]){
//				i++;
//				continue;
//			}
//			int remainder = gas[i] - cost[i];
//			int currentIndex = (i + 1) % gas.length;
//			int tempi = -1;
//			System.out.println("remainder:" + remainder + "; currentIndex:" + currentIndex + ";i:" + i);
//			while(currentIndex != i){
//				remainder += gas[currentIndex];
//				if(remainder < cost[currentIndex]){
//					tempi = currentIndex + 1;
//					break;
//				} else {
//					remainder -= cost[currentIndex];
//					currentIndex = (currentIndex + 1) % gas.length;
//				}
//			}
//			if(currentIndex == i){
//				return i;
//			}
//			System.out.println("tempi:" + tempi);
//			if(tempi >= gas.length){
//				break;
//			}
//			if(tempi != -1){
//				i = tempi;
//			} else {
//				i++;
//			}
//		}
//
//		return -1;
//	}
	
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
			return -1;
		}
		
		int len = gas.length;
		
		int[] remainder = new int[len];
		int sumTotal = 0;
		for(int i = 0; i < len; i++){
			remainder[i] = gas[i] - cost[i];
			sumTotal += remainder[i];
		}
		if(sumTotal < 0){
			return -1;
		}
		if(len == 1){
			if(remainder[0]>=0){
				return 0;
			} else {
				return -1;
			}
		}
	
		for(int i = 0; i < len;){
			if(remainder[i] < 0){
				i++;
				continue;
			}
			
			int currentIndex = i;
			int sum = 0;
			while(currentIndex < len){
				sum += remainder[currentIndex];
				if(sum < 0){
					break;
				} else {
					currentIndex++;
				}
			}
			if(currentIndex == len){
				return i;
			}
			i = currentIndex + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		GasStation instance = new GasStation();
//		int[] gas = {2,3,20,6,3};
//		int[] cost = {4,3,4,5,6};
		int[] gas = {2, 4};
		int[] cost = {3, 4};
		System.out.println(instance.canCompleteCircuit(gas, cost));

	}

}
