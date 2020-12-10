/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        // 看了tag的depth-first-search 以为无脑深度优先遍历就行了，
        // 结果验证到69/77 [5,4,6,null,null,3,7]发现问题
        // 改成中序遍历 二叉搜索树的中序遍历序列必定是递增序列
        // 可以利用这点验证二叉搜索树
        // 迭代完成中序遍历 顺手加固一下记忆
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            if (root.left != null) {
                stack.push(new TreeNode(root.val, null, root.right));
                root = root.left;
            } else {
                if (list.size() > 0) {
                    if (root.val <= list.get(list.size() - 1)) return false;
                }
                list.add(root.val);
                if (root.right == null) {
                    if (stack.empty()) {
                        root = null;
                    } else {
                        root = stack.pop();
                    }
                } else {
                    root = root.right;
                }
            }
        }
        return true;


        // // 深度优先遍历 栈实现
        // Stack<TreeNode> stack = new Stack<>();
        // int nodeVal;
        // while (root != null) {
        //     nodeVal = root.val;
        //     if (root.left != null) {
        //         // 新建节点不存储左子树避免死循环
        //         stack.push(new TreeNode(root.val, null, root.right));
        //         root = root.left;
        //         if (root.val >= nodeVal) return false;
        //     } else {
        //         if (root.right == null) {
        //             // 叶子节点 走另一条路劲
        //             if (stack.empty()) {
        //                 root = null;
        //             } else {
        //                 root = stack.pop();
        //             }
        //         } else {
        //             root = root.right;
        //             if(root.val <= nodeVal) return false;
        //         }
        //     }
        // }
        // return true;
    }
}
// @lc code=end

