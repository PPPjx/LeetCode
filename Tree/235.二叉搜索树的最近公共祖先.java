/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树最近的公共祖先 
        // 较小的节点必定在左子树 较大的节点在右子树
        TreeNode left;
        TreeNode right;
        if (p.val < q.val) {
            left = p;
            right = q;
        } else {
            left = q;
            right = p;
        }
        return helper(root, left, right);
    }

    public TreeNode helper(TreeNode root, TreeNode left, TreeNode right) {
        // 根据二叉树的性质 root节点的值必定在p和q之间
        // 都比root小
        if (right.val < root.val) return helper(root.left, left, right);
        // 都比root大
        if (root.val < left.val) return helper(root.right, left, right);
        return root;
    }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     // 不事先区分大小p
    //     if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
    //     // 都比root大
    //     if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
    //     return root;
    // }
}
// @lc code=end

