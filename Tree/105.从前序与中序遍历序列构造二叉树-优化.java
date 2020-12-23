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
    /**
     * 建立hash映射
     */
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 108题后改造 因为之前跑的时候占有内存和时间效率还蛮高的
        // 改了还是觉得有点复杂= =
        // 跑去看了题解，用了map存储了哈希映射，妙啊
        // （一次ac被打击 这就是写完不看题解还自我感觉良好吧哈哈哈哈，不过这时候我是想不到用映射
        int length = inorder.length;
        for (int i = 0; i < length; ++i) {
            // 将值与下标对应 方便前序遍历直接获取
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 取到根节点
        int nodeVal = preorder[preLeft];
        int index = map.get(nodeVal);
        TreeNode node = new TreeNode(nodeVal);

        // 划分左右子树 主要注意前序遍历的位置计算
        node.left = helper(preorder, inorder, preLeft + 1, preLeft + index - inLeft, inLeft, index - 1);
        node.right = helper(preorder, inorder, preLeft + 1 + index - inLeft, preRight, index + 1, inRight);

        return node;
    }
}
// @lc code=end

