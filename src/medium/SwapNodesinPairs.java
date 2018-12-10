package medium;

import util.ListNode;
import static util.Utils.*;

/**
 * 
 * ClassName: SwapNodesinPairs
 * @author chenyiAlone  
 * Create Time: 2018/12/10 10:59:40
 * Description: No.24
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode first = head, second = head.next;
        ListNode ans = new ListNode(0), temp = ans;
        while (first != null) {
            if (second == null) {
                temp.next = new ListNode(first.val);
                break;
            }
            temp.next = new ListNode(second.val);
            temp = temp.next;
            temp.next = new ListNode(first.val);
            temp = temp.next;
            first = second.next;
            if (first != null) second = first.next;
        }
        return ans.next;
    }
    public static void main(String[] args) {
        ListNode list = initListNode();
        System.out.println(new SwapNodesinPairs().swapPairs(list));
        
    }
}
