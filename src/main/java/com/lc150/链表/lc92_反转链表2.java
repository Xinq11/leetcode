package com.lc150.链表;

public class lc92_反转链表2 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode g = dummy, p = dummy.next;
        for (int i = 0; i < left - 1; i++) {
            g = g.next;
            p = p.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode node = p.next;

            p.next = node.next;
            node.next = g.next;
            g.next = node;
        }
        return dummy.next;
    }
}
