package com.hot100.linked;

/**
 * 2024.12.14 两数相加
 * https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=top-100-liked
 */
public class TwoLinkAdd {
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
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            int res = (l1Val + l2Val + flag) % 10;
            flag = (l1Val + l2Val + flag) / 10;
            ListNode node = new ListNode(res);
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
        return pre.next;
    }
}
