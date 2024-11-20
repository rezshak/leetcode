// https://leetcode.com/problems/lru-cache/

import java.util.*;

class LRUCache {

    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }

    private Map<Integer, Node> cache;
    private Node fakeHead, fakeTail;
    private int capacity;

    // S: O(capacity)
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        fakeHead = new Node(0, 0);
        fakeTail = new Node(0, 0);
        this.capacity = capacity;
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }

    // T: O(1)
    public int get(int key) {
        var node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    // T: O(1)
    public void put(int key, int value) {
        var node = cache.get(key);
        if (node == null) {
            if (cache.size() >= capacity) {
                removeTail();
            }
            node = new Node(key, value);
            cache.put(key, node);
        } else {
            node.value = value;
        }
        moveToHead(node);
    }

    private void moveToHead(Node node) {
        // Existing node
        if (node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = fakeHead.next;
        node.prev = fakeHead;
        fakeHead.next.prev = node;
        fakeHead.next = node;
    }

    private void removeTail() {
        var lastNode = fakeTail.prev;
        cache.remove(lastNode.key);
        lastNode.prev.next = fakeTail;
        fakeTail.prev = lastNode.prev;
    }

    public static void main(String[] args) {
        var lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // 1
        lru.put(3, 3);
        System.out.println(lru.get(2)); // -1
        lru.put(4, 4);
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(3)); // 3
        System.out.println(lru.get(4)); // 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
