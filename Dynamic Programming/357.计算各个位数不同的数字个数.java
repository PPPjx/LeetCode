/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        // n位数各位数字都不同的排列组合为 C10取n 且第一位不能为0 (9*9*8*...*(11-n))
        // 10的n次方内 则为各个m位数的累加(m <= n)
        int res = 10;
        for (int i = 2; i <= n; i++) {
            // 第一位为不包含0的9种可能
            int iRes = 9;
            for (int j = 2; j <= i; j++) {
                if (j == 2) {
                    // 第二位为10个数除去第一位选择的剩余九种可能
                    iRes *= 9;
                } else {
                    iRes *= (11 - j);
                }
            }
            res += iRes;
        }
        return res;
    }
}
// @lc code=end

