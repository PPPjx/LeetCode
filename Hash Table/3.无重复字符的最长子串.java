import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0, max = 0;
        // 题目Tags: 哈希表、双指针
        int left = 0, right = 0;
        // map存储右指针走过的字符
        HashMap<Character, Integer> map = new HashMap<>();
        for (; right < s.length(); ++right) {
            if (map.get(s.charAt(right)) != null) {
                if (map.get(s.charAt(right)) < left) {
                    length++;
                } else {
                    // 若该字符在左右指针中间出现 重置当前无重复字符串长度
                    left = map.get(s.charAt(right)) + 1;
                    length = right - left + 1;
                }
            } else {
                length++;
            }
            if (length > max) {
                max = length;
            }
            // 添加或者更新
            map.put(s.charAt(right), right);
        }
        return max;
    }
}
// @lc code=end

