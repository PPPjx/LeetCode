/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    // 再全局变量的情况下 如果不准时清除path的经过的节点肯定会造成错误
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }

    private void helper(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.val == sum && node.right == null && node.left == null) {
            res.add(new ArrayList<Integer>(path));
        }
        // 一次走一条路径
        helper(node.left, sum - node.val);
        helper(node.right, sum - node.val);
        // 当前节点处判断完之后 移除该节点 以免影响到其他路径
        path.remove(path.size() - 1);
    }
}
// @lc code=end