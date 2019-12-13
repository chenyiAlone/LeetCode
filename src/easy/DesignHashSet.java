package easy;

/**
 * ClassName: DesignHashSet.java
 * Author: chenyiAlone
 * Create Time: 2019/12/12 8:28
 * Description: No.705 Design HashSet
 */
public class DesignHashSet {


    private class Node {
        Node next;
        int key;
        Node() {}
        Node(int key) {
            this.key = key;
        }
    }

    private Node[] buckets;
    private int size;
    private int len = 64;

    /** Initialize your data structure here. */
    public DesignHashSet() {
        buckets = new Node[len];
        size = 0;
    }
    
    public void add(int key) {
        int pos = key & (len - 1);
        if (buckets[pos] == null) {
            buckets[pos] = new Node(key);
        } else {
            Node n = buckets[pos];
            while (n != null && n.key != key)
                n = n.next;
            if (n != null) 
                return;
            else {
                Node ins = new Node(key);
                ins.next = buckets[pos];
                buckets[pos] = ins;
            }
        }
        size++;
    }
    
    public void remove(int key) {
        int pos = key & (len - 1);
        if (buckets[pos] == null)
            return;
        Node prev = null, cur = buckets[pos];
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) return;
        if (prev == null) {
            buckets[pos] = buckets[pos].next;
        } else {
            prev.next = cur.next;
        }
        size--;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int pos = key & (len - 1);
        if (buckets[pos] == null)
            return false;
        Node prev = null, cur = buckets[pos];
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        if (cur != null)
            return true;
        else 
            return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */