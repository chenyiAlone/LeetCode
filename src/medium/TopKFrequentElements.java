package medium;
/**
 * ClassName: TopKFrequentElements.java
 * Author: chenyiAlone
 * Create Time: 2019/7/7 14:26
 * Description: No.347 Top K Frequent Elements
 * 思路:
 *      1. 快排的性质，两边的数，左边小于 base, 右边大于 base，L 和 R 中间可能存在一个值，等于 base 也可能不存在
 *      2. 将右侧合理的数据，放到结果中
 *      3. 三段区间
 *          l ~ R
 *          R ~ L
 *          L ~ r
 *      4. 如果右侧区间的个数小于
 *
 *
 *
 *
 *
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */
public class TopKFrequentElements {
}
