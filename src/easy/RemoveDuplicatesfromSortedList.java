package easy;

import util.ListNode;
/**
 * 
 * ClassName: RemoveDuplicatesfromSortedList
 * @author chenyiAlone  
 * Create Time: 2019/01/07 19:13:46
 * Description: No.83
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

    Example 1:
    
    Input: 1->1->2
    Output: 1->2
    Example 2:
    
    Input: 1->1->2->3->3
    Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == pointer.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }
}
