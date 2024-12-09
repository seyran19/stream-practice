package org.example.algs.original;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    /// [7,1,5,3,6,4]
    private static int profit;

    public static void main(String[] args) {
        int[] prices = {1, 2};
        System.out.println(maxProfit(prices));


    }

    public static int maxProfit(int[] prices) {

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - minValue);
            }
        }
        return profit;
    }
}
