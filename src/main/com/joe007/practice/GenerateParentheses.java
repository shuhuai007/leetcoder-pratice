package com.joe007.practice;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/17 : 10:56
 * End   Time : 2013/10/17 : 13:18
 *
 */
public class GenerateParentheses {

    public ArrayList<String> generateParenthesis(int n) {
        if(n == 0){
            return new ArrayList<String>();
        }
        if(n == 1){
            ArrayList<String> list = new ArrayList<String>();
            list.add("()");
            return list;
        }
        ArrayList<String> lastList = generateParenthesis(n - 1);
        ArrayList<String> resultList = new ArrayList<String>();

        for(String item : lastList){
            char [] charArr = item.toCharArray();
            for(int i = 0; i < charArr.length; i++){
                char [] newCharArr = new char[charArr.length + 2];
//                System.out.println("new Len:" + newCharArr.length);
                for(int j = 0; j < newCharArr.length; j++){
                    if(j <= i){
                        newCharArr[j] = charArr[j];
                    } else if( j == i+1){
                        newCharArr[j] = '(';
                    } else if( j == i+2){
                        newCharArr[j] = ')';
                    } else {
                        newCharArr[j] = charArr[j-2];
                    }
                }
                String newStr = String.valueOf(newCharArr);
                if(!resultList.contains(newStr)){
                    resultList.add(newStr);
                }
            }
            
        }

        return resultList;
    }

    public static void main(String[] args) {
        GenerateParentheses instance = new GenerateParentheses();
        System.out.println(instance.generateParenthesis(3));
    }

}
