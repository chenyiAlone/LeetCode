package easy;

/**
 * ClassName: DesignHashMap.java
 * Author: chenyiAlone
 * Create Time: 2019/12/11 16:54
 * Description: No.706 Design HashMap
 *
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 *
 */
public class DesignHashMap {

    private class Node {
        Node next;
        int key;
        int val;
        Node() {}
        Node(int val) {
            this.val = val;
        }
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node[] buckets;
    private int len = 64;
    private double load = 0.75;
    private int size;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        this.buckets = new Node[len];
        this.size = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int pos = key & (len - 1);
        if (buckets[pos] == null) {
            buckets[pos] = new Node(key, value);
        } else {
            Node n = buckets[pos];
            while (n != null && n.key != key)
                n = n.next;
            if (n != null) {
                n.val = value;
                return;
            } else {
                Node ins = new Node(key, value);
                ins.next = buckets[pos];
                buckets[pos] = ins;
            }
        }
        size++;
        if (size > (int)(len * load)) {
            Node[] oldBuckets = buckets;
            buckets = new Node[len * 2];
            for (int i = 0; i < len; i++) {
                if (oldBuckets[i] != null) {
                    Node lo = null, hi = null;
                    for (Node n = oldBuckets[i], next; n != null; ) {
                        next = n.next;
                        if ((n.key & len) != 0) {
                            n.next = hi;
                            hi = n;
                        } else {
                            n.next = lo;
                            lo = n;
                        }
                        n = next;
                    }
                    buckets[i] = lo;
                    buckets[i + len] = hi;
                }
            }
            len *= 2;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int pos = key & (len - 1);
        for (Node n = buckets[pos]; n != null; n = n.next)
            if (n.key == key)
                return n.val;
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int pos = key & (len - 1);
        Node prev = null, next = buckets[pos];
        while (next != null && next.key != key) {
            prev = next;
            next = next.next;
        }
        if (next == null) return;
        if (next == buckets[pos]) {
            buckets[pos] = buckets[pos].next;
        } else {
            prev.next = next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */