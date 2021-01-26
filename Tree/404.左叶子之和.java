/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        // 中序遍历 每次左叶子相加
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 左叶子
                if (root.left != null && root.left.left == null && root.left.right == null) {
                    res += root.left.val;
                    root = null;
                } else {
                    root = root.left;
                }
            }
            root = stack.pop().right;
        }

        return res;

    }
}
// @lc code=end