/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 不能在遍历中直接返回 需要判断是否满足条件 需要一个全局变量
        // 深度遍历 判断是否当前分支是否满足包含一个节点或者时当前节点就是指定的节点
        helper(root, p, q);
        return res;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        // 判断左（右）子树是否包含一个指定节点
        boolean left = helper(node.left, p, q);
        boolean right = helper(node.right, p, q);

        // 最近祖先节点
        // 左右子树同时满足 或者某个节点刚好是另一个节点的祖先
        if (left && right || (p == node || q == node && (left || right))) {
            res = node;
        }

        // 当前节点是p(q)
        // 当前分支子树满足包含p(q)条件 那么包含这子树的所有树都满足
        return left || right || node.val == p.val || node.val == q.val;
    }
}
// @lc code=end

