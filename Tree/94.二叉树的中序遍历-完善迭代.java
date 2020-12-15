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
        // 之前的迭代实现复杂了
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root != null || !stack.empty()) {
            while (root != null) {
                // 节点不为空则入栈
                // 中序遍历优先左节点 当左节点不为空的时候才将父节点出栈
                stack.push(root);
                root = root.left;
            }
            // 左节点为空 找到父节点
            root = stack.pop();
            res.add(root.val);
            // ld之后 找r
            root = root.right;
        }
        return res;
    }
}
// @lc code=end

