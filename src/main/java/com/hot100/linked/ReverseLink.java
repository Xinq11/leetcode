package com.hot100.linked;

/**
 * 2024.12.14 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
 */
public class ReverseLink {
    public static class ListNode {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(-1), cur = head;
        pre.next = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = head;
            head = pre.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ReverseLink reverseLink = new ReverseLink();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        reverseLink.reverseList(one);
    }
}
