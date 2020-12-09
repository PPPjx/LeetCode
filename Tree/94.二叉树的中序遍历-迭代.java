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
        // 迭代 小推大
        // 问题： 如何保留走过的路径？ => 栈
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        // 遍历树 ldr 每种遍历方式都需要改变
        while(root != null) {
            if (root.left != null) {
                // 根节点入栈 走左子树
                // 左子树置空防止再走
                TreeNode node = new TreeNode(root.val);
                node.right = root.right;
                stack.push(node);
                root = root.left;
            } else {
                // 这条路径到达终点 值入list
                res.add(root.val);
                // 右子树能否走得通
                if(root.right != null) {
                    root = root.right;
                } else {
                    // 走不通出栈
                    root = stack.empty() ? null : stack.pop();
                }
            }
        }

        return res;
    }
}
// @lc code=end

