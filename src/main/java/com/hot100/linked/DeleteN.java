package com.hot100.linked;

/**
 * 2024.12.14 删除链表的倒数第N个节点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-100-liked
 */
public class DeleteN {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        int index = size - n + 1;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        if (index == 1) {
            pre.next = head.next;
        } else {
            for (int i = 1; i < index; i++) {
                if (i == index - 1) {
                    head.next = head.next.next;
                }
                head = head.next;
            }
        }
        return pre.next;
    }
}
