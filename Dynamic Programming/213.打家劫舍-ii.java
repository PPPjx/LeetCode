/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 这个不得行 [2,2,4,3,2,5] 难顶
        // // 若偷最后一家则需要与第一家做取舍 或者是选择上一家的最大值
        // int length = nums.length;
        // if (length == 0) return 0;
        // if (length == 1) return nums[0];
        // if (length == 2) return Math.max(nums[0], nums[1]);
        // int[] dp = new int[length];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        // for (int i = 2; i < length; i++) {
        //     dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        //     if (i == length - 1) {
        //         // 根据偷的路径 寻找是否选择第一家
        //         int j = i;
        //         for (; j != 0 && j != 1; j--) {
        //             if (dp[j] != dp[j - 1]) {
        //                 j--;
        //             }
        //         }
        //         // 初始选择跳过2，3家类似情况
        //         if (j == 1 && nums[1] + nums[2] <= nums[0]) j--;
        //         // 选择第一家
        //         if (j == 0 && dp[i] != dp[i - 1]) {
        //             dp[i] = Math.max(dp[i] - nums[0], dp[i - 1]);
        //         }
        //     }
        // }

        // return dp[length - 1];

        // 看了题解，思路：环状可以拆分出两个单排列
        // 第一间不偷和最后一间不偷 （考虑第一间或最后一间不偷的时候会考虑到两件同时不偷的情况下）
        //临界
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int pre = 0, cur = 0, tmp;
        int withoutFirst = 0, withoutEnd = 0;
        // 不偷第一间
        for (int i = 1; i < nums.length; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        withoutFirst = cur;
        pre = 0; 
        cur = 0;
        // 不偷最后一间
        for (int i = 0; i < nums.length - 1; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        withoutEnd = cur;

        return Math.max(withoutEnd, withoutFirst);
    }
}
// @lc code=end

