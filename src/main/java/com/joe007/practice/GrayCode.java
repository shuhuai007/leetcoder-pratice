package com.joe007.practice;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

 * @author zhoujie
 * 
 * Start Time : 2013/10/14 : 15:39
 * End   Time : 2013/10/14 : 18:46
 */
public class GrayCode {
    /*
     *  000 0
     *  001 1
     *  011 3
     *  010 2
     *  110 6
     *  100 4
     *  101 5
     *  111 7
     *  
     *  0000 0
     *  0001 1
     *  0011 3
     *  0010 2
     *  0110 6
     *  0100 4
     *  0101 5
     *  0111 7
     *  1111 15
     *  1011 11
     *  1010 10
     *  1110 14
     *  1100 12
     *  1101 13
     *  1001 9
     *  1000 8
     *  
     *  
     *  
     *  
     *  
     */


    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if(n < 0){
            return new ArrayList<Integer>();
        }
        if(n == 0){
            resultList.add(0);
            return resultList;
        }
        int maxRoundCount = (int) Math.pow(2, n);
        int roundCount = 1;
        int[] lastPos = new int[n];
        for(int i = 0; i < lastPos.length; i++){
            lastPos[i] = 0;
        }
        resultList.add(0);
        
        while((++roundCount) <= maxRoundCount){
            lastPos = generateNewPos(n, lastPos, resultList);
        }
        return resultList;
    }

    private int[] generateNewPos(int n, int[] lastPos, ArrayList<Integer> resultList) {
        int[] newPos = lastPos;
        int newValue = 0;
        int lastValue = resultList.get(resultList.size() - 1);
        for(int i = lastPos.length -1; i >= 0;i-- ){
            int value;
            if(0 == lastPos[i]){
                // plus 1
                value = (int) (lastValue + Math.pow(2, n - i -1));
            } else{
                // sustract 1
                value = (int) (lastValue - Math.pow(2, n - i -1));
            }
            if(!resultList.contains(Integer.valueOf(value))){
                newValue = value;
                newPos[i] = Math.abs(lastPos[i] - 1);
                break;
            }
        }
        

        resultList.add(newValue);
        return newPos;
    }

    public static void main(String[] args) {
        GrayCode  instance = new GrayCode();
        System.out.println(instance.grayCode(4));
    }

}
