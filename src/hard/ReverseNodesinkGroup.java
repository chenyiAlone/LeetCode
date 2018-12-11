package hard;

import util.ListNode;
import static util.Utils.*;
/**
 * 
 * ClassName: ReverseNodesinkGroup
 * @author chenyiAlone  
 * Create Time: 2018/12/10 11:38:39
 * Description: No.25 
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        reverse(dummy, k);
        return dummy.next;
    }
    public static void reverse(ListNode head, int k) {
        int n = k;
        if (head == null || n < 2) return;
        if (head.next == null) return;
        ListNode list = head.next;
        ListNode ans = new ListNode(list.val), end = ans;
        list = list.next;
        ListNode temp;
        while (--n > 0 && list != null) {
            temp = new ListNode(list.val);
            temp.next = ans;
            ans = temp;
            list = list.next;
        }
//        System.out.println(list.val);
        if (n == 0) {   // 用于处理最后一部分不足k个结点的情况
            head.next = ans;
            end.next = list;
            reverse(end, k);
        }
        
    }
    public static void main(String[] args) {
        ListNode list = initListNode(1, 2, 3, 4, 5);
        System.out.println(new ReverseNodesinkGroup().reverseKGroup(list, 3));
//        ListNode dummy = new ListNode(0);
//        dummy.next = list;
//        System.out.println(dummy);
//        reverse(dummy, 5);
//        list = dummy.next;
//        System.out.println(list);
    }
}
