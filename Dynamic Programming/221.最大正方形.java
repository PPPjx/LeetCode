/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        // 动态规划 每个位置记录当前点为右下角的边长最大值
        int[][] dp = new int[matrix.length][matrix[0].length];
        // 记录最大边长
        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0 || i == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                }
                if (dp[i][j] > maxSize) {
                    maxSize = dp[i][j];
                }
            }
        }

        return maxSize * maxSize;
    }
}
// @lc code=end

