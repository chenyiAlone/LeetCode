package medium;

import util.ListNode;
/**
 * 
 * ClassName: RemoveDuplicatesfromSortedListII
 * @author chenyiAlone  
 * Create Time: 2019/03/14 18:13:26
 * Description: No.82
 * 总结:
 *     1. 使用 head 指针来判断当前节点和下一节点的 val 是否相等
 *     2. p 更新后继节点的时机分为两种
 *           i. head.val != head.val
 *          ii. head.next == null 此时 head 和 head.next 肯定是不相等的
 *     3. 当 head.val != head.next.val 后 head = head.next; 
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                p.next = head;
                p = p.next;
                
            } else {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
            }
            head = head.next;
        }
        p.next = null;
        return dummy.next;
        
    }
    
    public static void main(String[] args) {
        ListNode head = util.Utils.initListNode(1,1);
        util.Utils.printListNodes(new RemoveDuplicatesfromSortedListII().deleteDuplicates(head));
    }
}