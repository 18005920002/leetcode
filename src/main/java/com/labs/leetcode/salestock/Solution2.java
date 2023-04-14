package com.labs.leetcode.salestock;

/**
 * @Description: 股票卖出注释
 * @Author: tanyun.zheng
 * @Date: 2020/5/16
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int len = prices.length;
        for(int i=0;i<len;i++) {
            /*minPrice = Math.min(minPrice,prices[i]);
            maxPorift = Math.max(maxPorift,prices[i]-minPrice);*/
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4}; //{5,7,3,2,9,6,4,8};
        int profit = new Solution().maxProfit(prices);
        System.out.println(profit);
    }
}
