/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
        if (root == null) return root;

        // // 不考虑空间复杂度 层次遍历
        // Queue<Node> queue = new LinkedList<Node>();
        // queue.offer(root);

        // while (!queue.isEmpty()) {
        //     int levelLength = queue.size();
        //     Node pre = null;
        //     for (int i = 0; i < levelLength; ++i) {
        //         Node node = queue.poll();
        //         if (pre != null) {
        //             pre.next = node;
        //         } else {
        //             node.next = null;
        //         }
        //         // 下一层节点顺序入队列
        //         if (node.left != null) {
        //             queue.offer(node.left);
        //         }
        //         if (node.left != null) {
        //             queue.offer(node.right);
        //         }
        //         pre = node;
        //     }
        // }

        // return root;

        // 只使用常量级额外空间。
        // 在父级连接两个子节点 在当前层连接两个子树相邻的节点
        // 因为next已经能连接到当前的节点的右边兄弟节点
        // 右孩子节点就能指向当前节点的右边节点的左孩子节点

        // 下一层第一个节点
        Node nextFirst = null;
        Node node = root;

        while (node != null) {
            // 第一次进入先确认下一层起点
            if (nextFirst == null) {
                // 完美二叉树无需考虑是否第一个
                nextFirst = node.left;
            }

            // 子节点相连
            if (node.left != null) {
                node.left.next = node.right;
            }

            if (node.next != null) {
                // 两个相邻节点的相邻子节点相连
                if (node.right != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            } else {
                // 进入下一层
                node = nextFirst;
                nextFirst = null;
            }
        }

        return root;

    }
}
// @lc code=end