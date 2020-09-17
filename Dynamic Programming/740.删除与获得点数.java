/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除与获得点数
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        // 舍弃该位置的选择：前一个位置的最优解
        // 不舍弃则为：前前个位置的最优解加上当前位置的值之和

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max = nums[0];
        // 将数值平铺
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] all = new int[max + 1];
        Arrays.fill(all, 0);
        for (int i = 0; i < nums.length; i++) {
            all[nums[i]]++;
        }

        // 动态规划
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
        for (int i = 3; i < all.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + all[i] * i);
        }

        return dp[max];
        
    }
}
// @lc code=end

