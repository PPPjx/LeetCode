/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            // 与0或 转成字符串
            String binaryString = Integer.toBinaryString(i | 0);
            res[i] = binaryString.length() - binaryString.replaceAll("1", "").length();
        }
        return res;
    }
}
// @lc code=end

