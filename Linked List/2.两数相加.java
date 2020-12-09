/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 遍历链表 进位+1
        ListNode node = new ListNode((l1.val + l2.val) % 10);
        ListNode head = node;
        boolean flag = (l1.val + l2.val) >= 10;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null) {
            // 每位值计算
            int val = flag ? (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + 1 : (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            // 逢十进一
            flag = val >= 10;
            val = val % 10;
            node.next = new ListNode(val);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            node = node.next;
        }
        if (flag) node.next = new ListNode(1);
        return head;
    }
}
// @lc code=end

