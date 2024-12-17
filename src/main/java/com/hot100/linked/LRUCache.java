package com.hot100.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 2024.12.14 LRU缓存
 * https://leetcode.cn/problems/lru-cache/?envType=study-plan-v2&envId=top-100-liked
 */
public class LRUCache {
    class Node {
        Integer key;
        Integer val;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    Node head, tail;
    Integer cap;

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>(capacity);
        this.cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        head.pre = tail;
        tail.pre = head;
        tail.next = head;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        put(key, map.get(key).val);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.get(key) != null || map.size() >= cap) {
            Node del;
            if (map.get(key) != null) {
                del = map.get(key);
            } else {
                del = tail.pre;
            }
            System.out.println(del.key);
            del.pre.next = del.next;
            del.next.pre = del.pre;
            map.remove(del.key);
        }
        newNode.pre = head;
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
        map.put(key, newNode);
    }
}
