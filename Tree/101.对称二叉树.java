/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        // 递归
        // 如何确认递归点： 
        // 左子树和右子树对称，
        // 左子树和右子树如何对称：左子树的左孩子和右子树的右孩子，左子树右孩子和右子树的左孩子对称
        // 孩子子树是否对称也是相同的道理
        if (root == null) return true;
        return isSym(root.left, root.right);
    }
    // 是否对称 递归
    public boolean isSym(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        // 左子树p的左孩子和右子树q的右孩子 左子树p的右孩子和右子树q的左孩子是否对称
        if (p.val == q.val) {
            return isSym(p.left, q.right) && isSym(p.right, q.left);
        }
        return false;
    }
}
// @lc code=end

