/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 思路：dp记录每个位置的最大值
        int n = nums.length;
        if (n < 1) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            // 每次比较只需要知道左边一位和左边两位的值
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return nums[n - 1]; 
    }
}
// @lc code=end