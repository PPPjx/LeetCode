/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length <= 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // dp[0]表示0枚 方便动态规划是加减
        dp[0] = 0;
        // dp[i] = min(dp[i] - coins中的各种面值)
        for (int i = 1; i < dp.length; ++i) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[dp.length - 1] == amount + 1 ? -1 : dp[dp.length - 1];
    }
}
// @lc code=end

