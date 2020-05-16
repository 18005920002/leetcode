package com.labs.leetcode.salestock;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/5/16
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(prices[i]<prices[j]){
                    maxProfit = Math.max(maxProfit,prices[j]-prices[i]);
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = {5,7,3,2,9,6,4,8};
        int profit = new Solution().maxProfit(prices);
        System.out.println(profit);
    }
}
