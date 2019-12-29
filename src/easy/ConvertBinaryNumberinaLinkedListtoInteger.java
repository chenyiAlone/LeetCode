package easy;

import util.*;

/**
 * ClassName: ConvertBinaryNumberinaLinkedListtoInteger.java
 * Author: chenyiAlone
 * Create Time: 2019/12/29 21:56
 * Description: No.1290 Convert Binary Number in a LinkedList to Integer
 */
public class ConvertBinaryNumberinaLinkedListtoInteger {

    public int getDecimalValue(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret = ret * 2 + head.val;
            head = head.next;
        }
        return ret;
    }
    
}