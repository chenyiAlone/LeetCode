package hard;

import util.ListNode;
import static util.Utils.*;
/**
 * 
 * ClassName: MergekSortedLists
 * @author chenyiAlone  
 * Create Time: 2018/12/10 09:50:27
 * Description: No.23 采用自顶向上的归并算法
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        for (int i = 1; i < lists.length; i *= 2) {
            for (int j = 0; j + i < lists.length; j += 2*i) {
                ListNode l1 = lists[j];
                ListNode l2 = lists[j + i];
                ListNode endList = new ListNode(0);
                ListNode temp = endList;
                while (l1 != null || l2 != null) {
                    if      (l1 == null) { temp.next = new ListNode(l2.val); l2 = l2.next; }
                    else if (l2 == null) { temp.next = new ListNode(l1.val); l1 = l1.next; }
                    else if (l1.val < l2.val) { temp.next = new ListNode(l1.val); l1 = l1.next; }
                    else { temp.next = new ListNode(l2.val); l2 = l2.next; }
                    temp = temp.next;
                }
                lists[j] = endList.next;
            }
        }
        return lists[0];
    }
    public static void main(String[] args) {
//        ListNode lists[] = {initListNode(1, 4, 5), initListNode(1, 3, 4), initListNode(2, 6)};
        ListNode lists[] = {};
        System.out.println(new MergekSortedLists().mergeKLists(lists));
    }
}
