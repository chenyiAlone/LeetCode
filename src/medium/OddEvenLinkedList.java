package medium;

import util.ListNode;
/**
 * ClassName: OddEvenLinkedList.java
 * Author: chenyiAlone
 * Create Time: 2019/5/31 18:37
 * Description: No.328
 * 思路:
 *      两个指针，一个指向偶数，一个指向奇数，当奇数的后继为 Null 的时候 break， odd.next = even;
 *
 *
 *  Given a singly linked list, group all odd nodes together followed by the even nodes. Please note
 *  here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 *
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head, even = head.next;
        ListNode iter = even;
        while (iter != null) {
            odd.next = iter.next;

            if (odd.next == null) break;

            odd = odd.next;
            iter.next = odd.next;
            iter = iter.next;
        }
        odd.next = even;
        return head;
    }
}
