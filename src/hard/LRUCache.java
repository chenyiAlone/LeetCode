package hard;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * ClassName: LRUCache
 * @author chenyiAlone  
 * Create Time: 2019/04/26 12:50:39
 * Description: No.146
 * 思路: 
 *    1. Deque + HashMap
 *    2. class Node {
 *          int key;
 *          int val;
 *          Node pre;
 *          Node next;
 *      }
 *    3. 需要注意的地方就是到达 capacity 的时候，将尾部元素删除，cur 总是插入到 head 的 next 位置
 *    
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
    
    Follow up:
    Could you do both operations in O(1) time complexity?
    
    Example:
    
    LRUCache cache = new LRUCache(2);   // capacity 
    
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4    
 * 
 */
public class LRUCache {
    private class Node {
        Node pre;
        Node next;
        int val;
        int key;
        public Node() {}
        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
    
    int capac = 0;
    int len = 0;
    Node head = null;
    Node tail = null;
        
    Map<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capac = capacity;
    }
    
    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node cur = map.get(key);            
            
            res = cur.val;
            
            Node pre = cur.pre;
            Node next = cur.next;
            pre.next = next;
            next.pre = pre;
            
            head.next.pre = cur;
            cur.next = head.next;
            head.next = cur;
            cur.pre = head;
        }
        return res;
        
    }
    
    public void put(int key, int value) {
        Node cur = null;
        if (map.containsKey(key)) {
            cur = map.get(key);
            
            // cut cur form list
            Node pre = cur.pre;
            Node next = cur.next;
            pre.next = next;
            next.pre = pre;
            
            // set value to new value
            cur.val = value;
            
            // insert into list after head
            head.next.pre = cur;
            cur.next = head.next;
            head.next = cur;
            cur.pre = head;
        } else {
            cur = new Node(value, key);
            
            if (capac > len) {
                len++;
                map.put(key, cur);
            } else {
                
                // remove last
                Node last = tail.pre;
                last.pre.next = last.next;
                last.next.pre = last.pre;
                map.remove(last.key);
            }
            // insert into list after head
            head.next.pre = cur;
            cur.next = head.next;
            head.next = cur;
            cur.pre = head;
        }
        map.put(key, cur);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */