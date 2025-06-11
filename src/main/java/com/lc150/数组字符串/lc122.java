package com.lc150.数组字符串;

public class lc122 {
    public int maxProfit(int[] prices) {
        // 买不买 卖不卖 要换成 持有现金 还是 持有股票 这样四个操作就会变成两个
        int[][] dp = new int[prices.length][2];
        // 0 表示持有现金，1表示持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 股票变现金
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 现金变股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 返回现金
        return dp[prices.length - 1][0];
    }
}
