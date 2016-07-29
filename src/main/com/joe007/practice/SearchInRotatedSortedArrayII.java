package com.joe007.practice;

/**
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed? Would this affect the run-time complexity? How and why? Write a
 * function to determine if a given target is in the array.
 * 
 * @author zhoujie
 * 
 *         Start Time : 2013/10/22 : End Time : 2013/10/22 :
 */
public class SearchInRotatedSortedArrayII {

	public boolean search(int[] A, int target) {
		int i = 0;
		int j = A.length - 1;
		int mid = (i + j) / 2;

		while (i < j && mid != i) {
//			System.out.println("i:" + i + ", j:" + j + "; mid:" + mid);
			if (A[i] == target || A[j] == target || A[mid] == target) {
				return true;
			}

			if (A[i] == A[j]) {
				int k = i;
				while (k < j && A[k + 1] == A[i]) {
					k++;
				}
				i = k;
				k = j;
				while (k > i && A[k - 1] == A[j]) {
					k--;
				}
				j = k;
			}
			mid = (i + j) / 2;

//			System.out.println("----i:" + i + ", j:" + j + "; mid:" + mid);
			if (A[i] < A[j]) {
				// A[i...j] is already sorted.
				if (target > A[mid]) {
					i = mid;
				} else {
					j = mid;
				}
			} else if (A[i] >= A[j]) {
				if (target > A[i]) {
					// left part
					if (A[i] > A[mid]) {
						j = mid;
					} else if (target > A[mid]) {
						i = mid;
					} else {
						j = mid;
					}

				} else {
					// right part
					if (A[mid] > A[j]) {
						i = mid;
					} else if (target > A[mid]) {
						i = mid;
					} else {
						j = mid;
					}
				}

			}
			mid = (i + j) / 2;
		}

		if (A[i] == target || A[j] == target || A[mid] == target) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArrayII instance = new SearchInRotatedSortedArrayII();
		// int[] A = {10, 12, 15, 1, 5, 9};
		// int target = 100;

		int[] A = { 1, 3, 1, 1, 1 };
		int target = 3;

		// int[] A = {1,2,1};
		// int target = 2;
		System.out.println(instance.search(A, target));
	}

}
