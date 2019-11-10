package medium;

/**
 * ClassName: DesignLinkedList.java
 * Author: chenyiAlone
 * Create Time: 2019/11/9 21:47
 * Description: No.707 Design Linked List
 */
public class DesignLinkedList {

    public class Node {
        int val;
        Node prev, next;
        Node() {}
        Node(int val) {
            this.val = val;
        }
    }
    
    
    private Node head, tail;
    private int size;
    
    /** Initialize your data structure here. */
    public DesignLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node ret = head.next;
        while (index-- > 0) ret = ret.next;
        return ret.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node next = head.next;
        Node t = new Node(val);
        t.next = next;
        t.prev = head;
        head.next = t;
        next.prev = t;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node prev = tail.prev;
        Node t = new Node(val);
        t.next = tail;
        t.prev = prev;
        prev.next = t;
        tail.prev = t;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        index = index < 0 ? 0 : index;
        Node next = head.next;
        while (index-- > 0) next = next.next;
        Node t = new Node(val), prev = next.prev;
        t.next = next;)
        t.prev = prev;
        prev.next = t;
        next.prev = t;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node del = head.next;
        while (index-- > 0) del = del.next;
        del.prev.next = del.next;
        del.next.prev = del.prev;
        del.next = null;
        del.prev = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */