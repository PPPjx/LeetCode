/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 问题分解：每阶爬法相当于下一阶和下下阶爬法之和
        // f[n]=f[n-1]+f[n-2]
        if(n == 1) {
            return 1;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }
}
// @lc code=end

