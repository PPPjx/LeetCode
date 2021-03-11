/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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
    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        helper(t, true);
        return sb.toString();
    }
    private void helper(TreeNode node, boolean isRoot) {
        if (node == null) return;
        if (!isRoot) {
            sb.append("(");
        }
        // 添入当前节点
        sb.append(String.valueOf(node.val));
        // 特殊情况
        if (node.left == null && node.right != null) {
            sb.append("()");
        }
        // 左节点以及右节点
        helper(node.left, false);
        helper(node.right, false);
        // 闭合
        if (!isRoot) {
            sb.append(")");
        }
    }
}
// @lc code=end

