package medium;
/**
 * ClassName: DesignCircularQueue.java
 * Author: chenyiAlone
 * Create Time: 2019/11/6 20:18
 * Description: No.622 Design Circular Queue
 *
 *
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 *
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 *
 * Your implementation should support following operations:
 *
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 *  
 *
 * Example:
 *
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
 * circularQueue.enQueue(1);  // return true
 * circularQueue.enQueue(2);  // return true
 * circularQueue.enQueue(3);  // return true
 * circularQueue.enQueue(4);  // return false, the queue is full
 * circularQueue.Rear();  // return 3
 * circularQueue.isFull();  // return true
 * circularQueue.deQueue();  // return true
 * circularQueue.enQueue(4);  // return true
 * circularQueue.Rear();  // return 4
 *  
 * Note:
 *
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Queue library.
 *
 */
public class DesignCircularQueue {

    private class Node {
        Node prev;
        Node next;
        int val;
        Node() {}

        Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }

        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size, maxSize;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue(int k) {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
        maxSize = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == maxSize) return false;
        Node t = new Node(value);
        Node old = tail.prev;
        old.next = t;
        t.prev = old;
        t.next = tail;
        tail.prev = t;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) return false;
        Node next = head.next.next;
        head.next = next;
        next.prev = head;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) return -1;
        return head.next.val;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) return -1;
        return tail.prev.val;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == maxSize;
    }

}
