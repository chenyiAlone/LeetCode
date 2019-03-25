package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Interval;
/**
 * 
 * ClassName: InsertInterval
 * @author chenyiAlone  
 * Create Time: 2019/03/25 17:09:40
 * Description: No.57
 * 思路：
 *     57 题的思路和 56 题其实是一样的，只需要将这个 newInterval 添加到 intervals 中去再开始生成即可。
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
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    
    You may assume that the intervals were initially sorted according to their start times.
    
    Example 1:
    
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]
    Example 2:
    
    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * 
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null) return res;
        intervals.add(newInterval);
        int size = intervals.size();
        int[] arr = new int[size * 2];
        int[] l = new int[size];
        int[] r = new int[size];
        for (int i = 0; i < size; i++) {
            l[i] = intervals.get(i).start;
            arr[i] = l[i];
            r[i] = intervals.get(i).end;
            arr[i + size] = r[i];
        }
        Arrays.sort(arr);
        Arrays.sort(l);
        Arrays.sort(r);
        int l_board = 0;
        int count = 0;
        for (int i = 0, l_index = 0, r_index = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            while (l_index < size && arr[i] == l[l_index]) {
                count++;
                if (count == 1) {
                    l_board = arr[i];
                }
                l_index++;
            }
            while (r_index < size && arr[i] == r[r_index]) {
                count--;
                if (count == 0) {
                    res.add(new Interval(l_board, arr[i]));
                }
                r_index++;
            }
        }
        return res;
    }
}
