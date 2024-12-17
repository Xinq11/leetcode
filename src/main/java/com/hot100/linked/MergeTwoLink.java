package com.hot100.linked;

/**
 * 2024.12.14 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
 */
public class MergeTwoLink {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null || list2 != null) {
            if ((list1 != null && list2 != null && list1.val <= list2.val) || list1 != null && list2 == null) {
                cur.next = list1;
                list1 = list1.next;
            } else if ((list1 != null && list2 != null && list1.val > list2.val) || list1 == null && list2 != null) {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return head.next;
    }
}
