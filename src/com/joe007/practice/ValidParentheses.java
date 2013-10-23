package com.joe007.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/23 : 
 * End   Time : 2013/10/23 :
 *
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Map<Character, Character> bracketMap = new HashMap<Character, Character>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        Set<Character> leftBracketSet = new HashSet<Character>(bracketMap.values()); 
        Set<Character> rightBracketSet = bracketMap.keySet();

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(leftBracketSet.contains(currentChar)){
                stack.push(currentChar);
            } else if(rightBracketSet.contains(currentChar)) {
                if(stack.isEmpty()){
                    return false;
                }
                char actualBracket = stack.pop();
                char desiredBracket = bracketMap.get(currentChar);
                if(actualBracket != desiredBracket){
                    return false;
                }
            } else {
                // other character
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses instance = new ValidParentheses();
        String s = ")";
        System.out.println(instance.isValid(s));

    }

}
