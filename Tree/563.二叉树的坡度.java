/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    // 计算当前节点的子树和以及坡度
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = helper(node.left);
        int sumRight = helper(node.right);
        // 计算坡度
        res += Math.abs(sumLeft - sumRight);
        // 返回节点所有和
        return sumLeft + sumRight + node.val;
    }
}
// @lc code=end

