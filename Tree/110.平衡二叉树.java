/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    // public boolean isBalanced(TreeNode root) {
    //     // Your runtime beats 99.02 % of java submissions
    //     // Your memory usage beats 70.53 % of java submissions (38.5 MB)
    //     // 两层递归 时间复杂度有点高
    //     if (root == null) {
    //         return true;
    //     }
    //     // 左右子树是否平衡
    //     return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    // }

    // private int depth(TreeNode node) {
    //     if (node == null) {
    //         return 0;
    //     }
    //     return Math.max(depth(node.left), depth(node.right)) + 1;
    // }

    public boolean isBalanced(TreeNode root) {
        // 反而时间还变慢了 不是吧
        // Your runtime beats 5.38 % of java submissions
        // Your memory usage beats 77.85 % of java submissions (38.4 MB)
        // 自底向上 通过一个递归判断
        return height(root) >= 0;
    }

    /**
     * 仍旧是计算高度 只不过中间加了平衡树的判断
     */
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }
}
// @lc code=end

