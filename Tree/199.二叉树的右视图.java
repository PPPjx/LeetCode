/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        // 考虑不充分
        // List<Integer> res = new ArrayList<>();
        // // 可看见右边的遍历
        // while (root != null) {
        //     res.add(root.val);
        //     root = root.right == null ? root.left : root.right;
        // }
        // return res;

        // 还是层次遍历 后进先出
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // 栈存储 只用得到最顶上的值
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层次遍历 每层都得保留 下一层可视和上一层可视不在同一个子树下面
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.poll();
                if (i == levelLength - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }
}
// @lc code=end

