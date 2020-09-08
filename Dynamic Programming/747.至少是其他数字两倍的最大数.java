/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class Solution {
    public int dominantIndex(int[] nums) {
        int big = 0, bigger = 0, index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > bigger) {
                big = bigger;
                bigger = nums[i];
                index = i;
            } else if (nums[i] > big) {
                big = nums[i];
            }
        }
        return bigger - 2 * big >= 0 ? index : -1;
    }
}
// @lc code=end

