import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    // 备忘录
    private HashMap<String, Integer> map = new HashMap<>();
    private String str1 = "", str2 = "";
    public int minDistance(String word1, String word2) {
        // https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-mian-shi-ti-xiang-jie-by-labuladong/
        // 很易懂的讲解
        // 刚看到感觉是真nm难哦 看了题解之后 原来这么方便= =
        str1 = word1;
        str2 = word2;
        return dp(word1.length() - 1, word2.length() - 1);
    }
    public int dp(int i, int j) {
        if (map.get(i + "" +j) != null) {
            return map.get(i + "" +j);
        }
        // 哪边先到头 把剩下的都删掉
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        // 相等则不做任何操作
        if (str1.charAt(i) == str2.charAt(j)) {
            map.put(i + "" + j, dp(i - 1, j - 1));
        } else {
            // 计算插入、修改、删除的最小值
            map.put(i + "" + j, Math.min(Math.min(dp(i, j - 1) + 1, dp(i - 1, j - 1) + 1), dp(i - 1, j) + 1));
        }
        return map.get(i + "" + j);
    }
}
// @lc code=end

