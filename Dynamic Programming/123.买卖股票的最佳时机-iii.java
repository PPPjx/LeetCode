/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 根据上一题的思路 只不过是这次能买卖两次
        // 第二次买入必须要在上一次卖出之后 故可以将其拆分为两次单独交易
        // 枚举数组所有可拆成两个长度为2以上的不同数组
        if (prices.length < 4) {
            return singleProfit(0, prices.length, prices);
        }
        int max = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            max = Math.max(max, singleProfit(0, i + 1, prices) + singleProfit(i, prices.length, prices));
        }
        return max;
    }

    // 计算单次的最大收益
    public int singleProfit(int m, int n, int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[m], max = 0;
        for (int i = m + 1; i < n; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }
}
// @lc code=end

