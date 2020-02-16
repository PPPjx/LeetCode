import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        ////// 思路：到达每个点的当前最大面积分为两种情况 （很多漏洞= =）
        ////// 上方的点当前最大面积为m 左边的为n
        ////// n-1>=m：左边的长度能够和上方的矩形构成新的矩形 该点面积为2m
        ////// 否则则为 n+1； 0的话为0

        // 原本的思路写到后面发现到了该点不能形成新矩形的时候不能判断此时的最大长度（无法判断横纵）
        // 看了题解发现先计算每个点的最大宽度
        // 不是最优解 但是确实涵盖了我之前没考虑到的情况 看了发现而且之前的思路有点想当然
        if (matrix.length == 0)
            return 0;
        int max = 0;
        int[][] rec = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < rec.length; i++) {
            for (int j = 0; j < rec[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // 计算该点的最大宽度
                    int width = j == 0 ? 1 : rec[i][j - 1] + 1;
                    rec[i][j] = width;
                    // 向上循环计算该点的最大面积
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, rec[k][j]);
                        max = Math.max(max, width * (i - k + 1));
                    }
                }
            }
        }

        return max;
    }
}
// @lc code=end
