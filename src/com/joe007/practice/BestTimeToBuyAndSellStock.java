package com.joe007.practice;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/14 : 10:07
 * End   Time : 2013/10/14 
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0){
            return 0;
        }
        
//        int currentProfit = 0;
        int maxProfit = 0;
        int startIndex = 0;
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - prices[startIndex];
//            System.out.println("profit:" +profit);
            if(profit < 0){
                startIndex = i;
            } else {
                // profit > 0
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }

        }
//        maxProfit = Math.max(maxProfit, currentProfit);

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();
        int [] prices = {6,1,3,2,4,7};
        System.out.println(instance.maxProfit(prices));
    }

}
