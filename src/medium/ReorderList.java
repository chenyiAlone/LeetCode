package medium;

import util.ListNode;
import static util.Utils.*;
/**
 * 
 * ClassName: ReorderList
 * @author chenyiAlone  
 * Create Time: 2019/04/25 17:50:30
 * Description: No.143
 * 思路:
 *     1. 快慢指针找出中间节点将 list 分成两段
 *     2. 将后段进行逆序成为 half_rev
 *     3. 将逆序段 half_rev 间隔一个插到前面 head 中去 
 * 
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * 
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    
    You may not modify the values in the list's nodes, only nodes itself may be changed.
    
    Example 1:
    
    Given 1->2->3->4, reorder it to 1->4->2->3.
    Example 2:
    
    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 */
public class ReorderList {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4};
        ListNode listNode = initListNode(list);
        new ReorderList().reorderList(listNode);
        printListNodes(listNode);
        
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode iter = head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode half_rev = null;
        iter = slow.next;
        slow.next = null;
        
        // head: 1->2
        // half_rev: 3->4 to 4->3
        while (iter != null) {
            ListNode next = iter.next;
            iter.next = half_rev;
            half_rev = iter;
            iter = next;
        }
        
        iter = head;
        
        // head 1->2 to 1->4->2->3
        while (iter != null) {
            ListNode iter_next = iter.next;
            ListNode second_half_rev_next = (half_rev != null) ? half_rev.next : null;
            if (half_rev != null) {
                iter.next = half_rev;
                half_rev.next = iter_next;
                half_rev = second_half_rev_next;
                iter = iter_next;
            } else  
                iter = iter.next;
        }
    }
}