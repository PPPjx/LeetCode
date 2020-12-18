/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 反顺序 用栈实现
        Stack<TreeNode> stack = new Stack<>();
        // 左右遍历标识
        boolean flag = false;
        stack.push(root);
        // 层次遍历
        while(!stack.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            TreeNode node;
            // 下一层栈
            Stack<TreeNode> next = new Stack<>();
            // 都是出栈 不管是锯齿形的哪个方向
            while(!stack.isEmpty()) {
                node = stack.pop();
                // 值就按出栈的顺序加入
                levelList.add(node.val);
                // 根据标识判断是从左往右还是从右往左
                if (flag) {
                    // 从右往左入栈
                    if (node.right != null) next.push(node.right);
                    if (node.left != null) next.push(node.left);
                } else {
                    // 从左往右顺序入栈 这样出栈是从右往左
                    if (node.left != null) next.push(node.left);
                    if (node.right != null) next.push(node.right);
                }
            }

            // 取反
            flag = !flag;
            stack = next;
            res.add(levelList);
        }

        return res;
    }
}
// @lc code=end

