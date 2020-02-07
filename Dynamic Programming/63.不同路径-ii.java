/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 排除临界情况
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            obstacleGrid[0][0] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] != 1 && obstacleGrid[i - 1][0] == 1 ? 1 : 0);
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] != 1 && obstacleGrid[0][i - 1] == 1 ? 1 : 0);
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }

        // return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] / 2;
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
// @lc code=end

