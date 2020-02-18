/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 暴力解法
        // int max = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     for (int j = i; j < prices.length; j++) {
        //         if(prices[j] - prices[i] > max) {
        //             max = prices[j] - prices[i];
        //         }
        //     }
        // }

        // min max先记录第一对最大差值之后，此时min会空缺
        // 而当后面的谷底没有原先的小时 即使出现更高的峰顶，谷底仍旧应该是原先的min
        // 而当后面出现更低的时记录为min，但是当其最大差值任比不过原先的max的话依旧为max 以此类推
        if (prices.length == 0) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
// @lc code=end

