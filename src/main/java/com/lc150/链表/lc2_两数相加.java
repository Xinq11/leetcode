package com.lc150.链表;

public class lc2_两数相加 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            // 计算当前值
            int val = (l1Val + l2Val + flag) % 10;
            // 计算进位
            flag = (l1Val + l2Val + flag) / 10;
            ListNode node = new ListNode(val);
            head.next = node;
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (flag != 0) {
            ListNode node = new ListNode(flag);
            head.next = node;
        }
        return res.next;
    }
}
