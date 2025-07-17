package com.lc150.链表;

public class lc21_合并两个有序链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (list1 != null || list2 != null) {
            int v1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int v2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            ListNode node;
            if (v1 <= v2) {
                list1 = list1.next;
                node = new ListNode(v1);
            } else {
                list2 = list2.next;
                node = new ListNode(v2);
            }
            head.next = node;
            head = head.next;
        }
        return res.next;
    }
}
