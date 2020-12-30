/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // 相比上一题需要加更多的判断条件
        Node node = root;
        // 下一层的第一个节点
        Node nextFirst = null;

        while (node != null) {
            if (nextFirst == null) {
                // 左右子树都为空下次还是会进入
                nextFirst = node.left == null ? node.right : node.left;
            }
            // 同个节点下的子树连接
            if (node.left != null && node.right != null) {
                node.left.next = node.right;
            }

            // next链上节点节点子节点连接
            if (node.next != null) {
                Node pre = node.right != null ? node.right : node.left;
                node = node.next;
                // 水平遍历寻找下一个连接点
                while (node != null && pre != null) {
                    if (node.left != null) {
                        pre.next = node.left;
                        break;
                    } else if (node.right != null) {
                        pre.next = node.right;
                        break;
                    } else {
                        if (node.next == null) break;
                        node = node.next;
                    }
                }
            } else {
                // 跳转到下一层
                node = nextFirst;
                // 置空
                nextFirst = null;
            }
        }

        return root;

    }
}
// @lc code=end

