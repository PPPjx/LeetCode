/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        /**
         * 中序遍历的序列相同的值必定连在一起
         * 在中序遍历的时候 相同值的节点肯定也是紧接着的
         */
        int compareVal = Integer.MIN_VALUE, maxCount = 0, count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 比较顺序的序列临近的节点数据是否相同
            if (root.val == compareVal) {
                count++;
            } else {
                compareVal = root.val;
                count = 1;
            }
            // 如果比原先最多出现的节点次数多 则清空list
            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(root.val);
            } else if (count == maxCount) {
                list.add(root.val);
            }

            root = root.right;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }

        return res;
    }
}
// @lc code=end

