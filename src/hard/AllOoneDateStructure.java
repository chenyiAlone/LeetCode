package hard;

import java.util.HashMap;
import java.util.Map;
/**
 * ClassName: AllOoneDateStructure.java
 * Author: chenyiAlone
 * Create Time: 2019/8/25 11:25
 * Description: No.432 All O`one Data Structure
 * 思路:
 *      1. Head 双向链表用来记录出现的次数以及当前次数的单词的个数，Node 双向链表来记录所出现的单词
 *      2. 每次进行的都是 +1 或者 -1 操作，所以只需要进行 O(1) 的添加和删除操作即可
 *      3. 当 head 的 cnt 当前长度的单词的个数为 0 的时候就将当前结点删除
 *
 *
 *
 *
 * Implement a data structure supporting the following operations:
 *
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 *
 *
 *
 */
public class AllOoneDateStructure {
    class Node {
        String str = "";
        Node l, r;
        Head head;
        private Node() {}
        private Node(String key) {
            str = key;
        }
    }
    class Head {
        int val;
        int cnt;
        Node node;
        Head l, r;
        private Head() {
            node = new Node();
            node.r = new Node();
            node.r.l = node;
        }
    }
    private Head first, last;
    private Map<String, Node> map = new HashMap<>();


    private void deleteNode(Node n) {
        n.head.cnt--;
        n.l.r = n.r;
        n.r.l = n.l;
        if (n.head.cnt == 0) {
            deleteHead(n.head);
        }
    }

    private void deleteHead(Head h) {
        h.l.r = h.r;
        h.r.l = h.l;
    }

    private void createHead(Head l, Head r, int val) {
        Head h = new Head();
        h.val = val;
        l.r = h;
        r.l = h;
        h.l = l;
        h.r = r;
    }


    private void insertNode(Node n, int val) {
        Head h = n.head;
        int oldVal = h.val;
        if (val > oldVal) {
            h = h.r;
            if (h.val != val) {
                createHead(n.head, h, val);
                h = n.head.r;
            }
        } else if (val < oldVal) {
            h = h.l;
            if (h.val != val) {
                createHead(h, n.head, val);
                h = n.head.l;
            }
        }
        n.head = h;
        n.l = h.node;
        n.r = h.node.r;
        h.node.r.l = n;
        h.node.r = n;
        h.cnt++;
    }


    /** Initialize your data structure here. */
    public AllOoneDateStructure() {
        first = new Head();
        last = new Head();
        first.r = last;
        last.l = first;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int val = 1;
        Node n;
        if (map.containsKey(key)) {
            n = map.get(key);
            val = n.head.val + 1;
            Node insert = new Node(key);
            insert.head = n.head;
            map.put(key, insert);
            insertNode(insert, val);

            deleteNode(n);

        } else {
            n = new Node(key);
            n.head = first;
            map.put(key, n);
            insertNode(n, val);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            int oldVal = n.head.val;
            if (oldVal - 1 != 0) {
                Node insert = new Node(key);
                insert.head = n.head;
                insertNode(insert, oldVal - 1);
                map.put(key, insert);
            }
            deleteNode(n);
        }
    }

    private void p() {

        for (Head h = first; h != null; h = h.r) {
            System.out.print(h.val + ": ");
            for (Node n = h.node; n != null; n = n.r) {
                System.out.print(n.str + ", ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
        System.out.println();
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return last.l.node.r.str;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return first.r.node.r.str;
    }

}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */