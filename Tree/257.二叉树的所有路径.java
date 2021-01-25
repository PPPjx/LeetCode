/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        helper(root, new StringBuffer(""));
        return res;
    }

    private void helper(TreeNode node, StringBuffer path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            res.add(path.toString() + node.val);
        } 
        
        int length = path.length();
        // 添加指向
        path.append(node.val).append("->");
        helper(node.left, path);
        helper(node.right, path);
        // 还原
        path.delete(length, path.length());
    }
}
// @lc code=end

