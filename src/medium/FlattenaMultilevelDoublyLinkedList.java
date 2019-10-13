package medium;

import util.*;

/**
 * ClassName: FlattenaMultilevelDoublyLinkedList.java
 * Author: chenyiAlone
 * Create Time: 2019/10/13 21:24
 * Description: No.430 Flatten a Multilevel Doubly Linked List
 */
public class FlattenaMultilevelDoublyLinkedList {

    private Node guard = new Node(0);
    private Node cur = guard;
    private void dfs(Node n) {
        if (n == null) return;
        Node t = new Node(n.val);
        if (cur != guard) t.prev = cur;
        cur.next = t;
        cur = cur.next;
        dfs(n.child);
        dfs(n.next);
    }
    
    public Node flatten(Node head) {
        dfs(head);
        return guard.next;
    }
}