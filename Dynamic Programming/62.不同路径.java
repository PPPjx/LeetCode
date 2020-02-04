/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // 问题分解：到达某个点的可能可分为左边的点向右一步或者上面的点向下一步到达
        // 所以到达某点的路径为左边的点和上面的点的可能之和
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[n - 1][m - 1];
    }
}
// @lc code=end

