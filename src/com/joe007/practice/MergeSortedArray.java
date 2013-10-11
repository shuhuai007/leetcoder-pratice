package com.joe007.practice;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/11 : 16:02
 * End   Time : 2013/10/11 :
 *
 */
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        int i = 0;
        for(int j = 0; j < n; j++){
            int elemB= B[j];
            int insertPos = findInsertPos(A, m, i, elemB);
            insertElemB(A, m, insertPos, elemB);
            m++;
            i = insertPos;
        }
    }
    
    private void insertElemB(int[] a, int size, int insertPos, int elemB) {
        // move 
        for(int i = size - 1; i >= insertPos; i--){
            a[i + 1] = a[i];
        }
        // insert
        a[insertPos] = elemB;
    }

    private int findInsertPos(int[] a, int size, int i, int elemB) {
        int k = i;
        for(k = i; k < size; k++){
            if(elemB <= a[k]){
                break;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        MergeSortedArray instance = new MergeSortedArray();
        int sizeOfA = 10;
        int [] A = new int[sizeOfA];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        
        int sizeOfB = 3;
        int [] B = new int[sizeOfB];
        B[0] = 2;
        B[1] = 3;
        B[2] = 4;
        
        instance.merge(A, 0, B, 3);
        
        int newSize = 6;
        for(int i = 0; i < newSize; i++){
            System.out.print(A[i]);
            if(i != (newSize-1)){
                System.out.print(",");
            }
        }
        int[] m = {};
        System.out.println(m.length);
        
    }

}
