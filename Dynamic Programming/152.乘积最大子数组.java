/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // // 未考虑不连续的奇数情况下的最大值
        // // Testcase
        // // [1,2,-1,-2,2,1,-2,1,4,-5,4]
        // // Answer
        // // 8
        // // Expected Answer
        // // 1280
        // int maxProduct = nums[0];
        // // 存储每个位置最大的连续乘积
        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     dp[i] = nums[i];
        //     if (nums[i] * dp[i - 1] >= dp[i - 1]) {
        //         dp[i] = nums[i] * dp[i - 1];
        //     }
        //     // 特殊情况：连续两个负数
        //     if (i > 1) {
        //         if (nums[i] * nums[i - 1] * dp[i - 2] >= dp[i - 1]) {
        //             dp[i] = nums[i] * nums[i - 1] * dp[i - 2];
        //         } else if (nums[i] * nums[i - 1] * nums[i - 2] >= dp[i - 1]) {
        //             dp[i] = nums[i] * nums[i - 1] * nums[i - 2];
        //         }
        //     }
        //     if (nums[i] > dp[i]) dp[i] = nums[i];
        //     if (dp[i] > maxProduct) maxProduct = dp[i];
        // }
        // return maxProduct;
        
        // 考虑到不连续的偶数个奇数 同时需要知道连续乘积的最大值和最小值
        int maxProduct = Integer.MIN_VALUE, maxTemp = 1, minTemp = 1;
        for (int i = 0; i < nums.length; i++) {
            // 当前为负数 最大值与 最小值与当前负数乘积 对比
            if (nums[i] < 0) {
                int tmp = maxTemp;
                maxTemp = minTemp;
                minTemp = tmp;
            }
            // 维护最大最小值
            maxTemp = Math.max(maxTemp * nums[i], nums[i]);
            minTemp = Math.min(minTemp * nums[i], nums[i]);

            maxProduct = Math.max(maxProduct, maxTemp);
        }
        return maxProduct;
    }
}
// @lc code=end

