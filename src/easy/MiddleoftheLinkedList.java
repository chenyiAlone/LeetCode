package easy;

import util.*;

/**
 * ClassName: MiddleoftheLinkedList.java
 * Author: chenyiAlone
 * Create Time: 2019/10/15 21:17
 * Description: No.876 Middle of the Linked List
 */
public class MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode guard = new ListNode(0), fast = guard, slow = guard;
        guard.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }

}