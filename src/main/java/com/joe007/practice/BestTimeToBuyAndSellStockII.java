package com.joe007.practice;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Start Time : 2013/10/09 09:48
 * End   Time : 2013/10/09 14:39
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if(null == prices || 0 == prices.length){
            return 0;
        }
        int currentProfit = 0;
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - prices[i-1];
            if(profit >= 0){
                currentProfit += profit;
            }
        }

        return currentProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII instance = new BestTimeToBuyAndSellStockII();
        int[] prices = {1,2,3,4};
        System.out.println(instance.maxProfit(prices));
    }

}
