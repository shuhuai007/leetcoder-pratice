package com.joe007.practice;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 * @author zhoujie
 *
 * Start Time : 2013/10/11 : 14:32
 * End   Time : 2013/10/11 : 15:13
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        if(null == A || A.length == 0){
            return 0;
        }

        int i = 0;
        int j = A.length - 1;
        while(i <= j){
            System.out.println("i:" + i);
            int currentVal = A[i];
            if(currentVal == elem){
                // need to be deleted
                int index = findFirstNonEqualIndex(A, elem, i, j);
                if(index != i){
                    A[i] = A[index];
                }
                j = index - 1;
            } else {
                
            }
            i++;
        }
        
        return j + 1;
    }

    private int findFirstNonEqualIndex(int[] A, int elem, int i, int j) {
        while (j > i){
            if(A[j] != elem){
                break;
            }
            j--;
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveElement instance = new RemoveElement();
//        int [] A = {4, 5};
        int [] A = {1,2,3,4,7,4,9,10};
        int elem = 4;
        int newSize = instance.removeElement(A, elem);
        System.out.println("newSize: " + newSize);
        
        for(int i = 0; i < newSize; i++){
            System.out.print(A[i]);
            if(i != (newSize - 1)){
                System.out.print(",");
            }
        }

    }

}
