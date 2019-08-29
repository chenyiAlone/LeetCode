package medium;

import util.ListNode;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rsl1 = new ListNode(0), rsl2 = new ListNode(0);
        for (ListNode cur = l1; cur != null; ) {
            ListNode next = cur.next;
            cur.next = rsl1.next;
            rsl1.next = cur;
            cur = next;
        }
        for (ListNode cur = l2; cur != null; ) {
            ListNode next = cur.next;
            cur.next = rsl2.next;
            rsl2.next = cur;
            cur = next;
        }
        ListNode ret = new ListNode(0);
        int cy = 0;
        for (ListNode c1 = rsl1.next, c2 = rsl2.next; c1 != null || c2 != null; ) {
            int a = 0, b = 0;
            if (c1 != null) {
                a = c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                b = c2.val;
                c2 = c2.next;
            }
            int sum = a + b + cy;
            ListNode n = new ListNode(sum % 10);
            cy = sum / 10;
            n.next = ret.next;
            ret.next = n;
        }
        if (cy != 0) {
            ListNode n = new ListNode(cy);
            n.next = ret.next;
            ret.next = n;
        }
        return ret.next;
    }

}