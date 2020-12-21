/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 和前中确认基本相同
        // 后序最后一个元素是当前节点 将其前面的划分为左右子树

        if (inorder.length == 0) return null;

        int nodeVal = postorder[postorder.length - 1];
        int index = findIndex(inorder, nodeVal);

        int leftLength = index;
        int rightLength = inorder.length - index - 1;
        int[] leftInorder = new int[leftLength];
        int[] leftPostorder = new int[leftLength];
        int[] rightInorder = new int[rightLength];
        int[] rightPostorder = new int[rightLength];

        System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
        System.arraycopy(postorder, 0, leftPostorder, 0, leftLength);
        System.arraycopy(inorder, index + 1, rightInorder, 0, rightLength);
        System.arraycopy(postorder, leftLength, rightPostorder, 0, rightLength);

        TreeNode node = new TreeNode(nodeVal);
        node.left = buildTree(leftInorder, leftPostorder);
        node.right  = buildTree(rightInorder, rightPostorder);

        return node;
    }

    private int findIndex(int[] inorder, int target) {
        for(int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return 0;
    }
}
// @lc code=end

