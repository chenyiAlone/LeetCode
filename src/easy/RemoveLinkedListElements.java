package easy;

import util.ListNode;
/**
 * 
 * ClassName: RemoveLinkedListElements
 * @author chenyiAlone  
 * Create Time: 2019/01/04 22:59:46
 * Description: No.203
 * Remove all elements from a linked list of integers that have value val.

    Example:
    
    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer.next != null) {
            if (pointer.next.val == val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }
}
