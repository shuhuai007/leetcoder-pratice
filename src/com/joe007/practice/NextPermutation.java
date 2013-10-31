package com.joe007.practice;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * @author zhoujie
 * Start Time : 2013/10/31 : 13:15
 * End   Time : 2013/10/31 :
 *
 */
public class NextPermutation {

    public void nextPermutation(int[] num) {
        if (num == null || num.length <=1){
            return;
        }
        
        // find key index
        int i = -1;
        
        for(i = num.length - 2; i >= 0; i--){
            if(num[i] < num[i+1]){
                
                break;
            }
        }
        if(i < 0){
            reverse(num, 0, num.length-1);
            return;
        }
        int currentVal = num[i];
        int j = -1;
        if(i == num.length - 2){
            j = i + 1;
        } else {
            for(int index = i+1; index <= num.length - 1; index++){
                if(index == num.length - 1){
                    j = index;
                    break;
                }
                if(currentVal >= num[index + 1] && currentVal < num[index]){
                    j = index;
                    break;
                }
            }

        }

        
        System.out.println("i:" + i + "; j: " + j);
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        reverse(num, i+1, num.length - 1);
    }

    private void reverse(int[] num, int i, int j) {
        if(i >= j){
            return;
        }
        int indexSum = i+j;
        for(int index = i; index <= (i+j)/2; index++){
            int jIndex = indexSum - index;
            int temp = num[index];
            num[index] = num[jIndex];
            num[jIndex] = temp;
        }
    }

    public static void main(String[] args) {
        NextPermutation instance = new NextPermutation();
//        int[] num = {1,2,3,7,6,3,2};
        int[] num = {1,3,2};
        instance.nextPermutation(num);
        StringBuilder sb = new StringBuilder();
        for(int item : num){
            sb.append(item);
            sb.append(",");
        }
        System.out.println(sb.substring(0, sb.lastIndexOf(",")));
    }

}
