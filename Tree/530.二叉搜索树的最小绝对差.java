/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        // 二叉搜索树 中序遍历是升序序列
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int pre = -1;
        while (!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != -1) {
                int val = root.val - pre;
                if (val < res) {
                    res = val;
                }
            }
            pre = root.val;
            root = root.right;
        }
        return res;
    }
}
// @lc code=end

