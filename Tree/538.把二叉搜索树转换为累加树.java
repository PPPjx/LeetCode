/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    int max = 0;
    public TreeNode convertBST(TreeNode root) {
        // 累加树 当前节点是原先所有大于或等于原当前节点的值的和
        // 二叉搜索树的特性 右边节点大于当前节点
        // 从最右下子树开始计算
        if (root == null) return root;
        convertBST(root.right);
        max += root.val;
        root.val = max;
        convertBST(root.left);
        return root;
    }
}
// @lc code=end

