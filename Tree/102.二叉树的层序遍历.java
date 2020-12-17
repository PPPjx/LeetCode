/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 广度优先遍历
        // 层次 借助两个队列的逐层
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null ) return res;

        // 层次遍历
        while(!deque.isEmpty()) {
            // 当层的结果
            List<Integer> levelRes = new ArrayList<Integer>();
            // 定义下一层的队列
            Deque<TreeNode> next = new LinkedList<>();
            TreeNode node;
            // 取出当层队列左边的值
            while((node = deque.poll()) != null) {
                levelRes.add(node.val);
                // 从左到右存入
                if (node.left != null) {
                    next.offer(node.left);
                }
                if (node.right != null) {
                    next.offer(node.right);
                }
            }
            res.add(levelRes);
            // 将下一层替换到当前层
            deque = next;
        }

        return res;
    }
}
// @lc code=end

