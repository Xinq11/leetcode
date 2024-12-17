package com.hot100.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 2024.12.14 随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-100-liked
 */
public class RandomLink {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        Map<Node, Node> cachedNode = new HashMap<Node, Node>();

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            if (!cachedNode.containsKey(head)) {
                Node headNew = new Node(head.val);
                cachedNode.put(head, headNew);
                headNew.next = copyRandomList(head.next);
                headNew.random = copyRandomList(head.random);
            }
            return cachedNode.get(head);
        }
    }
}