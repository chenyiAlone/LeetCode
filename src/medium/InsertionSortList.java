package medium;

import util.ListNode;

import static util.Utils.initListNode;

/**
 * ClassName: InsertionSortList.java
 * Auther: chenyiAlone
 * Create Time: 2019/4/27 10:43
 * Description: No.147
 * 思路:
 *     1. pre->cur->next 记录连续的三个节点
 *     2. ins_pre 为插入位置的前一个节点
 *     3. if (ins_pre.next == cur) pre = pre.next;
 *        else insert cur to list after ins_pre;
 *
 *
 *
 * Sort a linked list using insertion sort.
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = initListNode(4, 2, 1, 3);
        ListNode res = new InsertionSortList().insertionSortList(head);
        System.out.println(res);
    }


    public ListNode insertionSortList(ListNode head) {
        ListNode guard = new ListNode(Integer.MIN_VALUE);
        for (ListNode cur = head, next = null; cur != null; cur = next) {
            next = cur.next;
            ListNode pre = guard;
            while (pre.next != null && cur.val > pre.next.val)
                pre = pre.next;
            ListNode pn = pre.next;
            cur.next = pn;
            pre.next = cur;
        }        
        return guard.next;
    }
}