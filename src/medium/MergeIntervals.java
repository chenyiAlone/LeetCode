package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Interval;
/**
 * 
 * ClassName: MergeIntervals
 * @author chenyiAlone  
 * Create Time: 2019/03/25 16:44:48
 * Description: No.56
 * 思路：
 *     当所有边界混在一起进行排序的时候，那么左右边界相互交错移动的距离是相等的。
 *     
 *     1. 使用两个数组分别储存 l_board 和 r_board ,以及一个储存两个边界的数组 arr
 *     2. 将三个数组都进行排序
 *     3. 设定 count 用于计数， l_board 用于储存左边界的起点，
 *     4. 从头遍历 arr ,跳过重复元素，if (i > 0 && arr[i] == arr[i - 1]) continue;
 *     5. 当扫描的元素和左边界相等的时候，那么 count++，count 为 1 的时候，更新 l_board，并重复这个循环
 *        当扫描的元素和右边界相等的时候，那么 count--，count 为 0 的时候，res 中添加新的 Interval(l_board, arr[i])
 *  
 *  
 *  Given a collection of intervals, merge all overlapping intervals.
    
    Example 1:
    
    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    Example 2:
    
    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.   
 * 
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null) return res;
        int size = intervals.size();
        int[] starts = new int[size];
        int[] ends = new int[size];
        int[] arr = new int[size * 2];
        for (int i = 0; i < size; i++) {
            starts[i] = intervals.get(i).start;
            arr[i] = starts[i];
            ends[i] = intervals.get(i).end;
            arr[i + size] = ends[i];
        }
        Arrays.sort(arr);
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count = 0;
        int l_board = 0;
        for (int start_index = 0, end_index = 0, i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            while (start_index < size && arr[i] == starts[start_index]) {
                count++;
                if (count == 1)
                    l_board = arr[i];
                start_index++;
            }
            while (end_index < size && arr[i] == ends[end_index]) {
                
                count--;
                if (count == 0) {
                    System.out.println(start_index + " " + end_index);
                    res.add(new Interval(l_board, arr[i]));
                }
                end_index++;
            }
        }
        return res;
    }
}

