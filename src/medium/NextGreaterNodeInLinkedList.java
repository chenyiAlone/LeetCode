package medium;

import util.*;
import java.util.*;

/**
 * ClassName: NextGreaterNodeInLinkedList.java
 * Author: chenyiAlone
 * Create Time: 2019/10/16 22:01
 * Description: No.1019 Next Greater Node In Linked List
 * 思路:
 *      stack + array
 *
 *
 *
 * We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 *
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
 *
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 *
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.
 *
 *  
 *
 * Example 1:
 *
 * Input: [2,1,5]
 * Output: [5,5,0]
 * Example 2:
 *
 * Input: [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 *
 */
public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) size++;
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[size];
        int[] nums = new int[size];
        int index = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) nums[index++] = cur.val;
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ret[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return ret;
    }

}