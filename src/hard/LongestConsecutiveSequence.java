package hard;

import java.util.HashSet;
/**
 * 
 * ClassName: LongestConsecutiveSequence
 * @author chenyiAlone  
 * Create Time: 2019/04/22 16:15:14
 * Description: No.128
 * 思路:
 *     1. 题目要求时间复杂度为 O(N) 所以这道题不能进行排序，也就只能使用 Hash 来做，当 
 *        bucket 的数量够大时那么查找的时间复杂就可以近似到 O(1)
 *     2. 使用 HashSet 既能排除掉重复元素
 *     3. 数组非有序，需要从正反双向进行查找
 *     
 *     
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    Your algorithm should run in O(n) complexity.
    
    Example:
    
    Input: [100, 4, 200, 1, 3, 2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.   
 *     
 * 
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            int count = 1;
            for (int i = n + 1; set.contains(i); i++) {
                set.remove(i);
                count++;
            }
            for (int i = n - 1; set.contains(i); i--) {
                set.remove(i);
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}