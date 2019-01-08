package medium;

import util.ListNode;

/**
 * 
 * ClassName: RotateList
 * @author chenyiAlone  
 * Create Time: 2019/01/08 16:32:59
 * Description: No.61
 *      遍历数组求出长度size，使用head和end两个指针，连成圆环，后移链表size - (k % size)，end指针重新指向null，返回head
 * 
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

    Example 1:
    
    Input: 1->2->3->4->5->NULL, k = 2
    Output: 4->5->1->2->3->NULL
    Explanation:
    rotate 1 steps to the right: 5->1->2->3->4->NULL
    rotate 2 steps to the right: 4->5->1->2->3->NULL
    Example 2:
    
    Input: 0->1->2->NULL, k = 4
    Output: 2->0->1->NULL
    Explanation:
    rotate 1 steps to the right: 2->0->1->NULL
    rotate 2 steps to the right: 1->2->0->NULL
    rotate 3 steps to the right: 0->1->2->NULL
    rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode end = head;
        int size = 1;
        while (end.next != null) {
            end = end.next;
            size++;
        }
        end.next = head;
        for (int i = 0; i < size - (k % size); i++) {
            head = head.next;
            end = end.next;    
        }
        end.next = null;
        return head;
    }
}
