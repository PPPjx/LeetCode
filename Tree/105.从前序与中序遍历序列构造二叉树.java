/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 根据前序遍历和中序遍历的结果 可以确定当前节点以及他的左子树和右子树的序列
        // 前序的首个值为当前节点
        // 中序当前节点的值划分左右子树
        // 再根据左右子树长度 在前序遍历中同样划分出左右子树

        // 两者遍历序列长度肯定是一样的
        if(preorder.length == 0) return null;
        
        int nodeVal = preorder[0];
        // 找到中序遍历中的当前节点位置
        int index = findIndex(inorder, nodeVal);
        TreeNode node = new TreeNode(nodeVal);

        // 中序遍历划分左右子树
        int leftLength = index;
        int rightLength = inorder.length - index - 1;
        // 左
        int[] leftPreorder = new int[leftLength];
        int[] leftInorder = new int[leftLength];
        // 右
        int[] rightPreorder = new int[rightLength];
        int[] rightInorder = new int[rightLength];
        System.arraycopy(preorder, 1, leftPreorder, 0, leftLength);
        System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
        System.arraycopy(preorder, leftLength + 1, rightPreorder, 0, rightLength);
        System.arraycopy(inorder, index + 1, rightInorder, 0, rightLength);

        node.left = buildTree(leftPreorder, leftInorder);
        node.right = buildTree(rightPreorder, rightInorder);

        return node;
    }

    /**
     * 找到目标数据在数组中的位置
     */
    private int findIndex(int[] arr, int target) {
        // 因为假设数中没有重复元素 那遍历序列中也没有重复的值
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == target) {
                return i;
            }
        }

        return 0;
    }
}
// @lc code=end

