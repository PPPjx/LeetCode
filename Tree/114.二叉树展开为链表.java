/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        // 原地：只改变原节点指针的指向 不要求空间复杂度为1
        // 展开是按前序遍历排列的
        // 若先考虑左子树的话 右子树需要临时保存
        if (root == null) return;

        // 225/225 cases passed (2 ms)
        // Your runtime beats 9.57 % of java submissions
        // Your memory usage beats 75.96 % of java submissions (37.9 MB)
        // 真慢啊
        // Stack<TreeNode> stack = new Stack<TreeNode>();
        // stack.push(root);
        // // 不记录的话会造成节点丢失
        // TreeNode pre = null;
        // while (!stack.isEmpty()) {
        //     TreeNode node = stack.pop();
        //     if (pre != null) {
        //         // 连接到上一个节点的右子树
        //         pre.right = node;
        //         pre.left = null;
        //     }
        //     // 右子树先入栈
        //     if (node.right != null) {
        //         stack.push(node.right);
        //     }
        //     // 左子树下次优先考虑
        //     if (node.left != null) {
        //         stack.push(node.left);
        //     }
        //     pre = node;
        // }

        // 在遍历的时候直接将右子树指向左子树 原先的右子树插到左子树最下方
        while (root != null) {
            // 左子树不为空
            if (root.left != null) {
                // 将原先的右子树插入到左子树的最右下的叶节点
                TreeNode node = root.left;
                // 遍历到最右下
                while(node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                // 右节点指向左节点
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }

    }
}
// @lc code=end

