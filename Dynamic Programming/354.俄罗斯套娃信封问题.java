/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        // 长升序 长相同宽降序
        Arrays.sort(envelopes, (front, next) -> {
            if (front[0] > next[0]) {
                return -1;
            } else if (front[0] == next[0]) {
                if (front[1] < next[1]) {
                    return -1;
                } else if (front[1] == next[1]) {
                    return 0;
                }
            }
            return 1;
        });
        // 问题分解为 求无序序列的最大上升序列
        // 获取宽升序的最大序列
        int[] dp = new int[envelopes.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j >= 0 ; j--) {
                if (envelopes[i][1] < envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
// @lc code=end

