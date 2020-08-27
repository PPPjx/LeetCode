/*
 * @lc app=leetcode.cn id=826 lang=java
 *
 * [826] 安排工作以达到最大收益
 */

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // 暴力 遍历每个人所能完成的最大收益 
        // 看题解用排序 也没说难度越高收益越大啊（啊这。。。）
        int sum = 0;
        for (int i : worker) {
            sum += maxProfitPer(difficulty, profit, i);
        }
        return sum;
    }

    /**
     * 单人最大收益
     */
    public int maxProfitPer(int[] difficulty, int[] profit, int worker) {
        int per = 0;
        for (int i = 0; i < difficulty.length; i++) {
            if (difficulty[i] <= worker) per = profit[i] > per ? profit[i] : per;
        }
        return per;
    }
}
// @lc code=end

