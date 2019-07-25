package medium;

import util.ListNode;

import java.util.Random;
/**
 * ClassName: LinkedListRandomNode.java
 * Author: chenyiAlone
 * Create Time: 2019/7/25 21:41
 * Description: No.382 Linked List Random Node
 * 思路:
 *
 *       1    2    3    4    5  ...    n
 *      1/1  1/2  1/3  1/4  1/5 ...   1/n
 *
 *
 *
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * Example:
 *
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 *
 */
public class LinkedListRandomNode {
    private ListNode list;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.list = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = list;
        int ret = 0;
        int cnt = 1;
        // random() * 3 < 1
        while (cur != null) {
            if (cnt * random.nextDouble() < 1) {
                ret = cur.val;
            }
            cur = cur.next;
            cnt++;
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */