package medium;

import java.util.*;

/**
 * ClassName: FindKPairswithSmallestSums.java
 * Author: chenyiAlone
 * Create Time: 2019/12/1 21:29
 * Description: No.373 Find K Pairswith Smallest Sums
 */
public class FindKPairswithSmallestSums {

    private class Pair<K, V> {
        K k;
        V v;
        
        Pair() {}
        Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
    
    private Pair<Long, List<Integer>> makePair(int a, int b) {
        return new Pair<Long, List<Integer>>((long)a + b, Arrays.asList(a, b));
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int size1 = nums1.length, size2 = nums2.length;
        PriorityQueue<Pair<Long, List<Integer>>> queue = new PriorityQueue<>(new Comparator<Pair<Long, List<Integer>>>() {
            @Override
            public int compare(Pair<Long, List<Integer>> p1, Pair<Long, List<Integer>> p2) {
                return p1.k < p2.k ? 1 : (p1.k == p2.k ? 0 : -1);
            }
        });
        List<List<Integer>> ret = new LinkedList<>();
        if (k == 0) return ret;
        
        for (int sum = 0; ; sum++) {
            boolean update = false;
            
            for (int i = Math.max(0, sum - (size2 - 1)); i <= Math.min(size1 - 1, sum); i++) {
                int j = sum - i;
                if (queue.size() < k) {
                    queue.offer(makePair(nums1[i], nums2[j]));
                    update = true;
                } else if ((long)nums1[i] + nums2[j] < queue.peek().k) {
                    queue.poll();
                    queue.offer(makePair(nums1[i], nums2[j]));
                    update = true;
                }
            }
            if (!update) break;
        }
        while (!queue.isEmpty()) ret.add(queue.poll().v);
        return ret;
    }
    
}