package easy;

import util.ListNode;
/**
 * 
 * ClassName: PalindromeLinkedList
 * @author chenyiAlone  
 * Create Time: 2019/03/13 20:30:26
 * Description: No.234
 * 总结: 
 *    思路快慢指针, tail 每次步进两个, mid 每次步进一个, 然后 head 配合 pre 将前半部分的链表进行反转
 *    1. pre 指针和 tail 首先指向 head 结点
 *    2. 判断 tail.next 和 tail.next 是否为 null , 也就是 快指针是否到达了 list 的尾端, 当 tail.next == null 的时候，
 *       list 有偶数个结点, 反之, 则有奇数个
 *    3. 当 tail 到达尾部的时候, 奇数时 head 指向中间的节点， 偶数指向 n / 2 处的结点
 *    4. 判断 tail.next 是否为 null , 也就是是否为奇数个, head 后移一位, eg: 1->2->3->2->1  head == 2->1  mid == 2->1
 * 
 * Given a singly linked list, determine if it is a palindrome.
    
    Example 1:
    
    Input: 1->2
    Output: false
    Example 2:
    
    Input: 1->2->2->1
    Output: true
    Follow up:
    Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode pre = head, mid = head.next, tail = head;
        while (tail.next != null && tail.next.next != null) {
            tail = tail.next.next;
            head = mid;
            mid = mid.next;
            head.next = pre;
            pre = head;
        }
        if (tail.next == null) head = head.next;
        while (mid != null) {
            if (head.val != mid.val) return false;
            mid = mid.next;
            head = head.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        ListNode head = util.Utils.initListNode(1, 2, 3, 2, 1);
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
    }
}