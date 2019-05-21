package hard;

import java.util.Collections;
import java.util.PriorityQueue;
/**
 * ClassName: FindMedianfromDataStream.java
 * Author: chenyiAlone
 * Create Time: 2019/5/21 14:55
 * Description: No.295
 * 思路:
 *      1. 使用两个优先队列来维护, samller 最大堆，bigger 最小堆，size 计数
 *      2. 已有元素为偶数的时候，向 smaller 插入，否则向 bigger 插入，以左边为例
 *          1). <= bigger 中的最小元素直接插入
 *          2). 将 bigger 中的最小元素插入 smaller 中，然后将 num 插入 bigger
 *
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 *
 *
 */
public class FindMedianfromDataStream {
    private PriorityQueue<Integer> smaller;
    private PriorityQueue<Integer> bigger;
    private int size;

    /** initialize your data structure here. */
    public FindMedianfromDataStream() {
        smaller = new PriorityQueue<>(Collections.reverseOrder());
        bigger = new PriorityQueue<>();
        size = 0;
        smaller.offer(Integer.MIN_VALUE);
        bigger.offer(Integer.MAX_VALUE);
        // bigger.offer(1);
        // bigger.offer(2);
        // System.out.println(bigger.poll() + " " + bigger.poll());

    }

    public void addNum(int num) {
        if (size % 2 == 0) {
            if (num <= bigger.peek()) {
                smaller.offer(num);
            } else {
                smaller.offer(bigger.poll());
                bigger.offer(num);
            }
        } else {
            if (smaller.peek() <= num) {
                bigger.offer(num);
            } else {
                bigger.offer(smaller.poll());
                smaller.offer(num);
            }
        }
        size++;
    }

    public double findMedian() {
        if (size == 0)
            return 0;
        else if (size % 2 == 1) {
            return smaller.peek();
        } else {
            return (smaller.peek() + bigger.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */