package com.lc150.链表;

import java.util.HashMap;
import java.util.Map;

public class lc146_LRU缓存 {
    class Node {
        Integer key;
        Integer value;
        Node pre;
        Node post;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        // set
        public Integer getValue(){
            return this.value;
        }
        public Integer getKey(){
            return this.key;
        }
        public void setValue(Integer value){
            this.value = value;
            return;
        }
        public void setKey(Integer key){
            this.key =key;
            return;
        }
    }
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int cap;

    public lc146_LRU缓存(int capacity) {
        // 初始化
        map = new HashMap<Integer,Node>(capacity);
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.post = tail;
        tail.pre = head;
        cap = capacity;
    }

    public int get(int key) {
        // 先判断map中是否存在
        if (map.containsKey(key)){
            // 调整key在链表中的顺序
            put(key, map.get(key).value);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.setValue(value);
            //重构node的位置
            node.pre.post=node.post;
            node.post.pre=node.pre;
        } else {
            // 超出容量 删除tail节点前一个节点
            if (map.size() == cap) {
                Node tmp = tail.pre;
                tmp.pre.post = tail;
                tail.pre = tmp.pre;
                map.remove(tmp.key);
            }
            node = new Node(key,value);
        }
        map.put(key, node);
        // 头插
        Node tmp = head.post;
        head.post = node;
        node.post = tmp;
        node.pre = head;
        tmp.pre = node;
    }
}
