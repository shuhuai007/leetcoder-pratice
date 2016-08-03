package com.joe007.practice;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 * @author zhoujie
 * 
 * Start Time : 2013/10/22 : 16:54
 * End   Time : 2013/10/22 :
 *
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x == 0){
            return true;
        }

        int digitNum = computerDigits(x);
        int lowIndex = 0;
        int highIndex = digitNum - 1;
        while(lowIndex < highIndex){
            int lowDigit =  x/(int)Math.pow(10, lowIndex)%10;
            int highDigit = x/(int)Math.pow(10, highIndex)%10;
            if(lowDigit == highDigit){
                lowIndex++;
                highIndex--;
            } else {
                break;
            }
        }
        
        return (lowIndex >= highIndex);
    }

    private int computerDigits(int x) {
        int digits = 0;
        while(x > 0){
            x = x /10;
            digits++;
        }
        return digits;
    }

    public static void main(String[] args) {
        PalindromeNumber instance = new PalindromeNumber();
        int x = 11;
        System.out.println(instance.isPalindrome(x));
//        System.out.println(instance.computerDigits(222));
    }

}
