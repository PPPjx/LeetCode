/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        // 与求最大深度相似 只不过取的最小值
        // 自顶向下
        if (root == null) {
            return 0;
        }
        // int left = minDepth(root.left);
        // int right = minDepth(root.right);
        // int leftHeight = left == 0 ? right : left;
        // int rightHeight = right == 0 ? left : right;
        // return Math.min(leftHeight, rightHeight) + 1;

        // 太慢了 优化
        // 同样是走的所有节点 减少递归函数的自我调用
        if (root.left == null && root.right == null) {
            return 1;
        }

        int minHeight = Integer.MAX_VALUE;
        // 不再不管是不是空都要走一层进去判断
        if (root.left != null) {
            minHeight = Math.min(minDepth(root.left), minHeight);
        }
        if (root.right != null) {
            minHeight = Math.min(minDepth(root.right), minHeight);
        }

        return minHeight + 1;
    }
}
// @lc code=end