/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // 暴力解法
        int n = s.length();
        if(n == 0) return "";
        if(n == 1) return s;
        String[] strs = new String[n];
        int maxLength = 0, index = 0;
        strs[0] = String.valueOf(s.charAt(0));
        strs[n - 1] = String.valueOf(n - 1);
        for (int i = 1; i < n; i++) {
            int l = 1;
            if (s.charAt(i) == s.charAt(i - 1)) {
                while (i - 1 - l >= 0 && i + l < n && s.charAt(i - 1 - l) == s.charAt(i + l)) {
                    l++;
                }
                l--;
                if (2 + 2 * l > maxLength) {
                    maxLength = 2 + 2 * l;
                    index = i;
                    strs[index] = s.substring(i - 1 - l, i + l + 1);
                }
            }
            if (i + 1 < n && s.charAt(i - 1) == s.charAt(i + 1)) {
                l++;
                while (i - l >= 0 && i + l < n && s.charAt(i - l) == s.charAt(i + l)) {
                    l++;
                }
                l--;
                if (2 * l + 1 > maxLength) {
                    maxLength = 2 * l + 1;
                    index = i;
                    strs[index] = s.substring(i - l, i + l + 1);
                }
            }
        }
        return strs[index];
    }
}
// @lc code=end