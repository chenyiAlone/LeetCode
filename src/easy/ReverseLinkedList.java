package easy;

import util.ListNode;

/**
 * 
 * ClassName: ReverseLinkedList
 * @author chenyiAlone  
 * Create Time: 2019/01/29 21:00:37
 * Description: No.206
 * 
 * Reverse a singly linked list.
    
    Example:
    
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode reverse = null;
        while (head != null) {
            ListNode pNext = head.next;
            head.next = reverse; 
            reverse = head;
            head = pNext;
            
        }
        return reverse;
    }
}
