package medium;

import util.ListNode;
import static util.Utils.*;
/**
 * 
 * ClassName: ReverseLinkedListII
 * @author chenyiAlone  
 * Create Time: 2019/01/09 18:30:01
 * Description: No.92
 *      dummy=> 虚拟头结点
 *      start=> 反转的部分链表的前一个结点
 *      end  => 反转链表的最后一个节点
 *      reverse=> 反转的部分链表
 *        
 * Reverse a linked list from position m to n. Do it in one-pass.
    
    Note: 1 ≤ m ≤ n ≤ length of list.
    
    Example:
    
    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0), start = dummy;
        dummy.next = head;
        
        for (int i = 1; i < m; i++) {
             start= start.next;
        }
        ListNode temp = start, reverse = null, end = null;
        for (int i = 0; i <= n - m; i++) {
            ListNode t = new ListNode(temp.next.val);
            if (i == 0) end = t;
            t.next = reverse;
            
            reverse = t;
            temp = temp.next;
        }
        //System.out.println("temp.val = " + temp.val);
        end.next = temp.next;;
        start.next = reverse;
        
        System.out.println(start.val);
        System.out.println(n - m);
        return dummy.next;
        
    }
    public static void main(String[] args) {
        ListNode list = initListNode(4);
        list = new ReverseLinkedListII().reverseBetween(list, 2, 4);
        printListNodes(list);
    }
}
/*

1
2
1->4->3->2->NULL

*///:~
