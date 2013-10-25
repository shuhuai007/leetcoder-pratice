package com.joe007.practice;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 * @author zhoujie
 * 
 * Start Time : 2013/10/25 : 13:42
 * End   Time : 2013/10/25 :
 *
 */
public class JumpGame {

    public boolean canJump(int[] A) {
        if(A == null || A.length == 0 || A.length == 1){
            return true;
        }
        if(A[0] == 0){
            return false;
        }

        for(int i = 1; i < A.length; i++){
            boolean pass = true;
            if(A[i] == 0){
                int j = i - 1;
                for(j = i - 1; j >= 0; j--){
                    if((i != (A.length - 1) && A[j] <= (i - j)) || (i == A.length - 1 && A[j] < (i - j))){
                        continue;
                    } else {
                        break;
                    }
                }
                if(j < 0){
                    pass = false;
                }
            }
            if(!pass){
                return pass;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        JumpGame instance = new JumpGame();
//        int[] A = {3,2,1,0,4};
        int[] A = {2,0,0};
//        int[] A = {1,1,0,1};
        
        System.out.println(instance.canJump(A));

    }

}
