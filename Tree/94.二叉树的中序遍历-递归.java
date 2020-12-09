/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 先实现递归
        List<Integer> res = new ArrayList<>();
        doInorderTraversal(root, res);
        return res;
    }

    /**
     * 递归实现
     */
    private void doInorderTraversal(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        if (node.left != null) {
            doInorderTraversal(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            doInorderTraversal(node.right, list);
        }
    }
}
// @lc code=end

