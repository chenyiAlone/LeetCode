package medium;

import static util.Utils.*;

import util.ListNode;
/**
 * 
 * ClassName: RemoveNthNodeFromEndofList
 * @author chenyiAlone  
 * Create Time: 2018/12/09 12:47:26
 * Description: 链表操作
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t = head;
        int len = 0;
        while (t != null) { // 求出链表的size
            t = t.next;
            len++;
        }
        n = len - n;    // 将n设置为为从前向后第几个数,因为范围为1 <= n <= size
                        //所以size-n得到的就是正向的第几个数此时的范围变成了 0 <= n < size
//        System.out.println(n);
        t = head;
        if (n == 0) return head.next;
        while (--n > 0) t = t.next;
        t.next = t.next.next;
        return head;
    }
    public static void main(String[] args) {
        // 1-> 2-> 3
        // size = 3;
        // n = 1;
        // n = size - n = 2 - 1 = 1;
        // n这里是第n个数, 1 <= n <= size
        ListNode list = initListNode(3);
        System.out.println(list);
        System.out.println(new RemoveNthNodeFromEndofList().removeNthFromEnd(list, 1));
        
    }
}
