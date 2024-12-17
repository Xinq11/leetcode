package com.hot100.linked;

/**
 * 2024.12.14 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=study-plan-v2&envId=top-100-liked
 */
public class SwapLink {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        pre.next = head;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            pre.next = next;
            head.next = next.next;
            next.next = head;
            pre = head;
            head = pre.next;
        }
        return res.next;
    }
}
