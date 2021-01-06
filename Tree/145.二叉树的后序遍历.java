/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 每个节点都走到最左下子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 找到最后走的节点
            root = stack.pop();
            // 判断是否有右节点
            if (root.right != null) {
                // 临时存放右节点
                TreeNode node = root;
                // 走到右节点的右子树
                root = root.right;
                // 右节点右子树置空 防止死循环
                node.right = null;
                // 原先右子树置空的右节点入栈
                // 这个节点后续只是单纯的拿来输出值 
                stack.push(node);
            } else {
                // 每个节点都是走到最左下的 无需管左子树
                res.add(root.val);
                root = null;
            }
        }

        return res;
    }
}
// @lc code=end

