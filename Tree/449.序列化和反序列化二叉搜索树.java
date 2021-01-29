/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
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
public class Codec {
    /**
     * 又没看到二叉搜索树= =
     * 没有利用到二叉搜索树的特性
     */
    /**
     * 不应使用成员变量等存储 应该是无状态的
     */
    /**
     * 思路：序列化层次遍历
     * 反序列化 通过栈一层层往下添加
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        String serial = "[";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层次遍历
        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.poll();
                serial += (node.val + ",");
                // -1暂存
                if (node.left != null) {
                    queue.offer(node.left);
                } else if (node.val != -1) {
                    queue.offer(new TreeNode(-1));
                }
                if (node.right != null) {
                    queue.offer(node.right);
                } else if (node.val != -1) {
                    queue.offer(new TreeNode(-1));
                }
            }
        }
        serial = serial.substring(0, serial.length() - 1) + "]";
        return serial;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        // 层次遍历构建
        // -1 则表示子节点为空
        // index记录全局指针走到哪里
        int index = 1;
        String[] arr = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        // 第一个肯定不为-1
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            for (int i = 0; i < levelLength && index <= arr.length; ++i) {
                TreeNode node = queue.poll();
                // 左右子节点判断
                if (!"-1".equals(arr[index])) {
                    TreeNode left = new TreeNode(Integer.parseInt(arr[index]));
                    node.left = left;
                    queue.offer(left);
                }
                ++index;
                if (!"-1".equals(arr[index])) {
                    TreeNode right = new TreeNode(Integer.parseInt(arr[index]));
                    node.right = right;
                    queue.offer(right);
                }
                ++index;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end

