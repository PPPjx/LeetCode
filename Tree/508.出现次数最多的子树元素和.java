/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
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
    // hashtable 存储每个节点为根节点的子树的子树元素和
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        dfs(root);
        // 从map中找出出现数量最多的子树元素和
        List<Integer> list = new ArrayList<>(map.values());
        List<Integer> res = new ArrayList<>();
        // list排序
        list.sort((a, b) -> {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        });
        // 最大出现的次数
        int maxCount = 1;
        int count = 1;
        res.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) == 0) {
                count++;
            } else {
                count = 1;
            }
            if (count == maxCount) {
                res.add(list.get(i));
            } else if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add(list.get(i));
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            arr[i] = res.get(i);
        }
        
        return arr;
    }

    /**
     * 深度优先遍历 统计每个子树元素和并存入hash表中
     */
    private int dfs(TreeNode node) {
        TreeNode left = node.left, right = node.right;
        int leftSum, rightSum;
        if (left != null) {
            if (map.get(left) != null) {
                // hash表中存在则直接拿出
                leftSum = map.get(left);
            } else {
                leftSum = dfs(left);
            }
        } else {
            leftSum = 0;
        }

        if (right != null) {
            if (map.get(right) != null) {
                rightSum = map.get(right);
            } else {
                rightSum = dfs(right);
            }
        } else {
            rightSum = 0;
        }

        int sum = leftSum + rightSum + node.val;
        map.put(node, sum);
        return sum;
    }
}
// @lc code=end

