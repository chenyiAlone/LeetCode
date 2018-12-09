package easy;

import util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.You may assume the two numbers do 
 * not contain any leading zero, except the number 0 itself.
 * Example:
 *      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      Output: 7 -> 0 -> 8
 *      Explanation: 342 + 465 = 807.
 * 
 * @author chenyiAlone
 * 
 * date 2018.11.28 
 *      当年做的题自己没想通，最后粘了的一份答案，现在看来，其实就是遍历两个链表，将每个结点的值进行相加
 * 超过十的时候向后一位进位，这样，carry/10得到的就是进到下一节点的值，使用sum表示进位以及两个加数之和，
 * carry求其进位为了下一次循环中的求和运算，while外面的if用于最后一个的进位的判断
 * 
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while(p != null || q!=null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next; 
            if (q != null) q = q.next; 
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return dummyHead.next;
    }
}

