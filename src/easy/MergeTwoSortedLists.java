package easy;
/**
 * @author chenyiAlone
 * @date 2018.11.30
 */
public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p = new ListNode(0);
		ListNode header = p;
		while (l1 != null || l2 != null) {
			if 		(l1 == null) { p.next = new ListNode(l2.val); l2 = l2.next;}
			else if (l2 == null) { p.next = new ListNode(l1.val); l1 = l1.next; }
			else if (l1.val <l2.val) { p.next = new ListNode(l1.val); l1 = l1.next; }
			else { p.next = new ListNode(l2.val); l2 = l2.next; }
			p = p.next;
	
		}
		// return header.next;		//手机的AIDE不知为什么老是报错，代码是没问题，在leetcode通过了
		return null;
    }
	 
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

