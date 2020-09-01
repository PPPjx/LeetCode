/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        // rowNum 当前行占有数量
        int row = 1, rowNum = 0;
        for (char c : S.toCharArray()) {
            if (widths[c - 97] + rowNum > 100) {
                rowNum = widths[c - 97];
                row++;
            } else {
                rowNum += widths[c - 97];
            }
        }
        return new int[]{row, rowNum};
    }
}
// @lc code=end

