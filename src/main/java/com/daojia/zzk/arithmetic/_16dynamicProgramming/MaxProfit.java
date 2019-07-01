package com.daojia.zzk.arithmetic._16dynamicProgramming;

/**
 * @author zhangzk
 * 买卖股票的最佳时记
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class MaxProfit {

    /**
     * 记录【今天之前买入的最小值】
     * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     * 比较【每天的最大获利】，取最大值即可
     * */
    int maxProfit (int[] prices) {
       if (prices.length <= 1) {
           return 0;
       }

       int min = prices[0];
       int max = 0;

        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /**
     * 买卖股票的时机2
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * */
    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] - prices[i] > 0) {
                max += (prices[i+1] - prices[i]);
            }
        }

        return max;
    }
}
