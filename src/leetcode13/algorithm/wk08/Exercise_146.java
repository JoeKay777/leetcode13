package leetcode13.algorithm.wk08;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 */
public class Exercise_146 {

    class LRUCache {

        class DLinkedNode {
            Integer key;
            Integer val;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode(Integer key, Integer val) {
                this.key = key;
                this.val = val;
            }
        }

        private int capacity;
        private int size;
        private DLinkedNode head;
        private DLinkedNode tail;

        private Map<Integer, DLinkedNode> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            cache = new HashMap<>(capacity);
            head = new DLinkedNode(null, null);
            tail = new DLinkedNode(null, null);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 移到头部
            moveToHead(node);
            return node.val;
        }

        private void moveToHead(DLinkedNode node) {
            remove(node);
            addToHead(node);
        }

        // 移动到头部
        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                node = new DLinkedNode(key, value);
                // 已满移除最后
                if (capacity == cache.size()) {
                    cache.remove(tail.prev.key);
                    remove(tail.prev);
                    size--;
                }
                cache.put(node.key, node);
                addToHead(node);
                size++;
            } else {
                node.val = value;
                moveToHead(node);
            }
        }

        private void remove(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }
}
