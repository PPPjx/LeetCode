/*
 * @lc app=leetcode.cn id=650 lang=java
 *
 * [650] 只有两个键的键盘
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        // 能否等分 无法等分只能复制粘贴
        int divisior = divide(n);
        if (divisior == -1) {
            // 无法等分只能一步一步复制粘贴
            return n;
        } else {
            int[] dp = new int[divisior + 1];
            dp[1] = 0;
            dp[2] = 2;
            for (int i = 3; i <= divisior; i++) {
                int div = divide(i);
                if (div == -1) dp[i] = i;
                else {
                    dp[i] = dp[div] + i / div;
                }
            }
            return dp[divisior] + n / divisior;
        }
    }

    // 最大等分点
    public int divide(int n) {
        for (int i = n / 2; i >= 2; --i) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

