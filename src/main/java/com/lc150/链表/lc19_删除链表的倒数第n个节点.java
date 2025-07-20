package com.lc150.链表;

public class lc19_删除链表的倒数第n个节点 {
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
        ListNode vitrualNode = new ListNode(-1);
        vitrualNode.next = head;
        ListNode res = vitrualNode;
        // 计算长度
        ListNode tag = head;
        int length = 0;
        while (tag != null) {
            tag = tag.next;
            length++;
        }
        // 删除节点
        int index = 0;
        while (vitrualNode != null) {
            if (index == length - n) {
                vitrualNode.next = vitrualNode.next.next;
                break;
            }
            vitrualNode = vitrualNode.next;
            index++;
        }
        return res.next;
    }
}
