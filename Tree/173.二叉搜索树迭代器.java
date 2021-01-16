/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {
    /**
     * 开始想的是在创建的时候迭代一轮 将顺序放入list中 到时候只要一个一个取就行
     * 此方法均摊下来时间复杂度为O(1)
     * 但是内存用的是O(n)并不满足
     * 
     * 利用二叉树的性质中序遍历时顺序的 每次只要找中序遍历的下一个节点就可以了
     * 将迭代放入拆成多个次 而不是一次性迭代完
     * 每次都知道当初节点的最下面 此时内存满足O(h) 且时间均摊下来也是O(1)
     */

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        helper(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            helper(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // 当前节点往左下遍历就是最小的
    private void helper(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

