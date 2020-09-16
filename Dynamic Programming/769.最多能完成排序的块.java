/*
 * @lc app=leetcode.cn id=769 lang=java
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        // 思路：与已升序数组对比（因为规定了排列，即自己的下标
        // 每段之间的排列必定满足 preMax与i之间打乱的序列
        int preMax = arr[0], sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (i >= arr[i] && i >= preMax) {
                sum++;
            }

            if (arr[i] > preMax) {
                preMax = arr[i];
            }
        }
        return sum;
    }
}
// @lc code=end

