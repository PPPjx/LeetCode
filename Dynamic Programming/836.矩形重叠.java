/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 矩形重叠
 */

// @lc code=start
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 不重叠的情况 上下左右（2相对1）
        // 上 rec2[1] >= rec1[3]
        // 下 rec2[3] <= rec1[1]  
        // 左 rec2[2] <= rec1[0]
        // 右 rec2[0] >= rec1[2]
        return !(rec2[1] >= rec1[3] || rec2[3] <= rec1[1] || rec2[2] <= rec1[0] || rec2[0] >= rec1[2]);
    }
}
// @lc code=end

