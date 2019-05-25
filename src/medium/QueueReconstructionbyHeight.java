package medium;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
/**
 * ClassName: QueueReconstructionbyHeight.java
 * Author: chenyiAlone
 * Create Time: 2019/5/25 13:31
 * Description: No.406
 * 思路:
 *      1. 观察结果可见，h 相同的 k 更大的会排到后面
 *      2. 从 h 最高的开始枚举，按照 k 插入到指定的位置即可
 *      3. PrioitryQueue使用的最小堆，返回的值是最小的
 *      4. 自定义实现 Comparator<Pair> 比较器，o1 > o2, return 1 就是按照升序排列，返回的最小值
 *      5. LinkedList 在指定位置添加元素 add(int index, E element)
 *
 *
 *
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 */
public class QueueReconstructionbyHeight {
    private class Pair {
        int h;
        int k;
        private Pair(int h, int k) {
            this.h = h;
            this.k = k;
        }

        @Override
        public String toString() {
            return "[" + this.h + ", " + this.k + "]";
        }
    }


    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if (len == 0)
            return new int[][]{};
        PriorityQueue<Pair> que = new PriorityQueue<>((p1, p2)-> {
                if (p1.h != p2.h)
                    return -(p1.h - p2.h);
                else
                    return p1.k - p2.k;
        });
        LinkedList<Pair> list = new LinkedList<>();
        for (int[] item : people) {
            que.add(new Pair(item[0], item[1]));
        }
        while (!que.isEmpty()) {
            Pair p = que.poll();
            list.add(p.k, p);
        }
        int index = 0;
        int[][] res = new int[len][2];
        for (Pair p : list)
            res[index++] = new int[]{p.h, p.k};

        return res;
    }
}
