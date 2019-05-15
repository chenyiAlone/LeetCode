package medium;

import java.util.Deque;
import java.util.LinkedList;
/**
 * ClassName: SlidingWindowMaximum.java
 * Author: chenyiAlone
 * Create Time: 2019/5/15 16:31
 * Description: No.239
 * 思路:
 *      1. 优先双端队列 Deque 数组的下标作为优先级，Deque 中保存数组的下标，也就是优先级
 *      2. 入队操作
 *              pollLast() 所有的小于 nums[i]
 *      3. 取值
 *              1). 将队首元素加入 res
 *              2). 将队首所有超时的元素 pollFirst()
 *
 *  -------------- Deque -----------------
 *      LinkedList<E> implements Deque<E>:
 *          peekFirst()
 *          peekLast()
 *          pollFirst()
 *          pollLast()
 *  --------------------------------------
 *
 *  Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k == 0)
            return new int[]{};
        // k %= len;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < len; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1)
                res[index++] = (deque.peekFirst() > i - k + 1) ? nums[deque.peekFirst() ]:  nums[deque.pollFirst()];
        }
        return res;

    }

}
