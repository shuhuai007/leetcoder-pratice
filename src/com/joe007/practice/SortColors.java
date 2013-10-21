package com.joe007.practice;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 * @author zhoujie
 * 
 * Start Time : 2013/10/18 : 14:06
 * End   Time : 2013/10/18 :
 *
 */
public class SortColors {

    public void sortColors(int[] A) {
        if(A == null || A.length == 0 || A.length == 1){
            return;
        }
        int beginIndex = 0;
        int endIndex = A.length - 1;
        while(beginIndex < endIndex){
            if(A[beginIndex] == 0){
                beginIndex++;
                continue;
            }
            if(A[endIndex] == 2){
                endIndex--;
                continue;
            }
            if(beginIndex == endIndex){
                break;
            }
            if(A[beginIndex] != A[endIndex]){
                swap(A, beginIndex, endIndex);
            } else {
                // both are 1
                int flag = 1;
                for(int index = beginIndex + 1; index < endIndex; index++){
                    if(A[index] != 1){
                        flag = A[index];
                        swap(A, index, beginIndex);
                        break;
                    }
                }
                if(flag == 1){
                    break;
                }

            }
            
        }
    }

    private void swap(int[] a, int index, int beginIndex) {
        int temp = a[index];
        a[index] = a[beginIndex];
        a[beginIndex] = temp;
    }

    public static void main(String[] args) {
        SortColors instance = new SortColors();
        int[] A = {1,2,2,2,2,0,0,0,1,1};
        instance.sortColors(A);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < A.length; i++){
            sb.append(A[i]);
            
            if(i != A.length - 1){
                sb.append(",");
            }
        }
        System.out.print(sb);

    }

}
