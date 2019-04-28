package medium;

import util.ListNode;

import static util.Utils.initListNode;

/**
 * ClassName: SortList.java
 * Auther: chenyiAlone
 * Create Time: 2019/4/28 10:29
 * Description: No.148
 * 思路:
 *
 *
 */
public class SortList {
    private ListNode dummy = null;

    public static void main(String[] args) {
        ListNode head = initListNode(3, 4, 2, 1);
        ListNode res = new SortList().sortList(head);
        System.out.println(res);
    }

    private ListNode sortList(ListNode head) {
        dummy = new ListNode(0);
        dummy.next = head;

        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        mergeSort(0, len - 1);
        return dummy.next;
    }

    private void mergeSort(int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) >> 1;
        mergeSort(lo, mid);
        mergeSort(mid + 1, hi);

        // (0, 1]
        ListNode pre = searchPre(lo);
        int leftLen = mid - lo + 1;
        int rightLen = hi - mid;    // right sublist include mid node
        mergeList(pre, leftLen, rightLen);

    }

    private void mergeList(ListNode pre, int leftLen, int rightLen) {
        int offset = leftLen;
        ListNode leftList = pre.next;
        ListNode rightList = pre.next;
        while (offset-- > 0) {
            rightList = rightList.next;
        }
        while (leftLen > 0 || rightLen > 0) {
            if (leftLen == 0) {
                pre.next = rightList;
                rightList = rightList.next;
                rightLen--;
            } else if (rightLen == 0) {
                pre.next = leftList;
                leftList = leftList.next;
                leftLen--;
            } else if (leftList.val < rightList.val) {
                pre.next = leftList;
                leftList = leftList.next;
                leftLen--;
            } else {
                pre.next = rightList;
                rightList = rightList.next;
                rightLen--;
            }
            pre = pre.next;
        }
        pre.next = rightList;
    }

    private ListNode searchPre(int index) {
        ListNode iter = dummy;
        for (int i = 0; i < index; i++) {
            iter = iter.next;
        }
        return iter;
    }
}