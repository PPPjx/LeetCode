/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    public TreeNode deleteNode(TreeNode root, int key) {
        /**
         * 删除之后要更新的情况：
         * 与前一个节点比较判断情况 将原先的左子树节点插入到右子树还是右子树插入到左子树
         */
        if (root == null) return root;
        // 上一个节点
        TreeNode prev = null;
        // 遍历节点
        TreeNode node = root;
        while (node != null) {
            if (node.val < key) {
                prev = node;
                node = node.right;
            } else if (node.val > key) {
                prev = node;
                node = node.left;
            } else {
                // 相等
                TreeNode left = node.left;
                TreeNode right = node.right;
                // 清空节点的连接
                node.left = null;
                node.right = null;
                if (prev == null) {
                    // 根节点
                    root = right != null ? right : left;
                } else {
                    // 非根节点
                    // 大取小 小取大
                    if (node.val > prev.val) {
                        prev.right = left != null ? left : right;
                        // 将right接到left最下方
                        if (left != null) {
                            while (left.right != null) {
                                left = left.right;
                            }
                            left.right = right;
                        }
                        return root;
                    } else {
                        prev.left = right != null ? right : left;
                    }
                }
                // 将left接到right最下方
                if (right != null) {
                    while (right.left != null) {
                        right = right.left;
                    }
                    right.left = left;
                }
                return root;
            }
        }
		
        return root;
    }
}
// @lc code=end

