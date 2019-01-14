package medium;

import util.ListNode;
/**
 * 
 * ClassName: ParitionList
 * @author chenyiAlone  
 * Create Time: 2019/01/14 20:33:30
 * Description: No.89
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    
    You should preserve the original relative order of the nodes in each of the two partitions.
    
    Example:
    
    Input: head = 1->4->3->2->5->2, x = 3
    Output: 1->2->2->4->3->5
 */
public class ParitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode biggers = new ListNode(0), bd = biggers;
        ListNode litters = new ListNode(0), ld = litters;
        while (head != null) {
            ListNode temp = null;
            if (head.val < x) {
                temp = new ListNode(head.val);
                ld.next = temp;
                ld = ld.next;
            } else {
                temp = new ListNode(head.val);
                bd.next = temp;
                bd = bd.next;
            }
            head = head.next;
        }
        ld.next = biggers.next;
        return litters.next;
        
    }
}
