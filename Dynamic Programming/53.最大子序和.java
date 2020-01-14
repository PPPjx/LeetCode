/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length, max = nums[0];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        // 用一个临时数组记录当前位置最大的子序和
        for (int i = 1; i < length; i++) {
            if (nums[i] + sums[i - 1] <= nums[i]) {
                sums[i] = nums[i];
            } else {
                sums[i] = nums[i] + sums[i - 1];
            }
            if (sums[i] > max) {
                max = sums[i];
            }
        }
        return max;
    }
}
// @lc code=end

