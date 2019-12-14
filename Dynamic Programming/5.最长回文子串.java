/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // // 暴力解法
        // if (s == null || s.length <= 1) {
        //     return s;
        // }
        // int n = s.length();
        // String[] strs = new String[n];
        // int maxLength = 0, index = 0;
        // strs[0] = String.valueOf(s.charAt(0));
        // strs[n - 1] = String.valueOf(n - 1);
        // for (int i = 1; i < n; i++) {
        //     int l = 1;
        //     if (s.charAt(i) == s.charAt(i - 1)) {
        //         while (i - 1 - l >= 0 && i + l < n && s.charAt(i - 1 - l) == s.charAt(i + l)) {
        //             l++;
        //         }
        //         l--;
        //         if (2 + 2 * l > maxLength) {
        //             maxLength = 2 + 2 * l;
        //             index = i;
        //             strs[index] = s.substring(i - 1 - l, i + l + 1);
        //         }
        //     }
        //     if (i + 1 < n && s.charAt(i - 1) == s.charAt(i + 1)) {
        //         l++;
        //         while (i - l >= 0 && i + l < n && s.charAt(i - l) == s.charAt(i + l)) {
        //             l++;
        //         }
        //         l--;
        //         if (2 * l + 1 > maxLength) {
        //             maxLength = 2 * l + 1;
        //             index = i;
        //             strs[index] = s.substring(i - l, i + l + 1);
        //         }
        //     }
        // }
        // return strs[index];

        // 中心扩展算法 区分字符串的奇偶，可以从一个字符扩展或者两个字符中间的的位置扩展，因此总共有n+(n-1)个中心
        // 上面的和这好像有点相似之处 从奇偶下手 不过strs的O(n)空间完全是多余的 可以只用一个String字符串代替
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = expandAroundCenter(s, i, i);
            // 此处将 i i+1 传入， 将判断归入while省去if判断 也可以反映出n+(n-1)个中心
            // 最后一个 s.length()-1 s.length() 是无效循环
            int len1 = expandAroundCenter(s, i, i + 1);
            len = Math.max(len, len1);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
        // 马拉车 先放着= =
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
// @lc code=end