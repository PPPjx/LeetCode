/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        // 计算到每个点的最短路径
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if(j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = grid[i - 1][j] > grid[i][j - 1] ? grid[i][j - 1] + grid[i][j] : grid[i - 1][j] + grid[i][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
// @lc code=end

