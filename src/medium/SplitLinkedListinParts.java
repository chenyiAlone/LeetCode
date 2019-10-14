package medium;

import util.*;

/**
 * ClassName: SplitLinkedListinParts.java
 * Author: chenyiAlone
 * Create Time: 2019/10/14 20:30
 * Description: No.725 Split Linked List in Parts
 */
public class SplitLinkedListinParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        for (ListNode cur = root; cur != null; cur = cur.next)
            size++;
        int n = size / k;
        ListNode[] ret = new ListNode[k];
        int tk = 0;
        for (ListNode cur = root; tk < k; tk++) {
            ListNode t = cur;
            ret[tk] = cur;
            
            for (int cnt = 1; cnt * k + tk < size && t != null; cnt++)
                t = t.next;
            cur = t == null ? t : t.next;
            if (t != null) t.next = null;
        }
        return ret;
    }
}