package com.hot100.linked;

/**
 * 2024.12.14 环形链表2
 * https://leetcode.cn/problems/linked-list-cycle-ii/?envType=study-plan-v2&envId=top-100-liked
 */
public class CycleLinkTwo {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                if (fast == slow) {
                    while (slow != head) {
                        slow = slow.next;
                        head = head.next;
                    }
                    return slow;
                }
            }
        }
        return null;
    }
}
