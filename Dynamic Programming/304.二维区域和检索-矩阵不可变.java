/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
public class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if (matrix.length > 0) {
            for (int i = 1; i < matrix[0].length; i++) {
                matrix[0][i] += matrix[0][i - 1];
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] += (j == 0 ? matrix[i - 1][j] : matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1]);
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2][col2] - (row1 > 0 ? matrix[row1 - 1][col2] : 0) - (col1 > 0 ? matrix[row2][col1 - 1] : 0) + (row1 > 0 && col1 > 0 ? matrix[row1 - 1][col1 - 1] : 0);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

