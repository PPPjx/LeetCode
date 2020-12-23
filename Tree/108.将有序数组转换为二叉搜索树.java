/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    // public TreeNode sortedArrayToBST(int[] nums) {
    //     /* 惨淡= =
    //         32/32 cases passed (1 ms)
    //         Your runtime beats 6.06 % of java submissions
    //         Your memory usage beats 5.47 % of java submissions (39.1 MB)
    //     */

    //     // 因为只是给出一种可能 就给出最容易的 每次都对半分
    //     int length = 0;
    //     if ((length = nums.length) == 0) {
    //         return null;
    //     }

    //     // length/2 中间位置或者中间右边的作为根节点
    //     int nodeVal = nums[length / 2];
    //     // 创建当前节点
    //     TreeNode node = new TreeNode(nodeVal);

    //     // 根据该节点划分左右子树继续创建
    //     int[] leftTree = new int[length / 2];
    //     int[] rightTree = new int[length - length / 2 - 1];
    //     // 复制
    //     System.arraycopy(nums, 0, leftTree, 0, length / 2);
    //     System.arraycopy(nums, length / 2 + 1, rightTree, 0, rightTree.length);

    //     node.left = sortedArrayToBST(leftTree);
    //     node.right = sortedArrayToBST(rightTree);

    //     return node;
    // }
    public TreeNode sortedArrayToBST(int[] nums) {
        // 相同的思路 看了题解 不要每次都复制 不过这次是取中间的左边作为根节点
        // 那之前的根据两种序列确定树也可以优化了
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 确定位置
        int index = (left + right) / 2;
        TreeNode node = new TreeNode(nums[index]);

        node.left = helper(nums, left, index - 1);
        node.right = helper(nums, index + 1, right);

        return node;
    }
}
// @lc code=end

