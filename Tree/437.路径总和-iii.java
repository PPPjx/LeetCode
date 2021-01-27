/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    /**
     * 很慢
     */
    private int res = 0;
    private int finalSum;
    // 记录子节点起始的次数
    private Map<TreeNode, Integer> nodeMap = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        finalSum = sum;
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) return;
        // 一个节点的选择：
        // 走左右子节点带当前节点
        // 走左右子节点不带当前节点 (重新开始计算)
        int temp = sum - node.val;
        if (temp == 0) {
            res++;
        }
        dfs(node.left, temp);
        dfs(node.right, temp);
        // 重新开始每次都要考虑是否会在之前的递归中重复
        if (nodeMap.get(node.left) == null) {
            dfs(node.left, finalSum);
            nodeMap.put(node.left, 1);
        }
        if (nodeMap.get(node.right) == null) {
            dfs(node.right, finalSum);
            nodeMap.put(node.right, 1);
        }
    }
}
// @lc code=end

