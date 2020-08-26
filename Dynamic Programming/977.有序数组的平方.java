/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        int index = 0;
        int[] res = new int[A.length];
        // 找出第一个非负数的下标
        for (; index < A.length; index++) {
            if (A[index] >= 0) break;
        }
        // 负数结束位置 minusIndex
        int minusIndex = index - 1;
        // res数组遍历位置 resIndex
        int resIndex = 0;
        for (; index < A.length; index++) {
            if (minusIndex < 0) res[resIndex] = A[index] * A[index];
            else {
                if (-A[minusIndex] > A[index]) {
                    res[resIndex] = A[index] * A[index];
                } else {
                    res[resIndex] = A[minusIndex] * A[minusIndex];
                    index--;
                    minusIndex--;
                }
            }
            resIndex++;
        }
        while (minusIndex >= 0) {
            res[resIndex++] = A[minusIndex] * A[minusIndex--];
        }
        return res;
    }
}
// @lc code=end

