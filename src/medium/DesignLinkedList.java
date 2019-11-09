package medium;

/**
 * ClassName: DesignLinkedList.java
 * Author: chenyiAlone
 * Create Time: 2019/11/9 21:47
 * Description: No.707 Design Linked List
 */
public class DesignLinkedList {

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