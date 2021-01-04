/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return helperDfs(root, 0);
    }

    private int helperDfs(TreeNode node, int preSum) {
        if (node == null) return 0;
        int sum = preSum * 10 + node.val;
        // 叶子节点计算完毕
        if (node.right == null && node.left == null) {
            return sum;
        } else {
            return helperDfs(node.left, sum) + helperDfs(node.right, sum);
        }
    }
}
// @lc code=end

