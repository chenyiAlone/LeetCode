package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * ClassName: CombinationSumII
 * @author chenyiAlone  
 * Create Time: 2019/03/21 15:05:15
 * Description: No.40
 * 
 * 思路：
 *   这道题的思路和前面的 Combination Sum 其实一样的，只不过增添了的跳过多选时候的相同元素
 *   
 *   candidates = [2,5,2,1,2], target = 5
 *   
 *   1. 先将数组排序，得到 [1, 2, 2, 2, 5]
 *   2. DFS 搜索时，if (i > index && nums[index] == nums[i - 1]) ,这里指选中的元素跟前一个元素的值相同
 *            就跳过这个元素 
 *   3. 比如扫到 [1] 进入迭代扫描出 [1, 2]，同级别的迭代下一次尝试的时候，就会跳过 2
 *   
 *   
 *   
 *   
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
    
    Each number in candidates may only be used once in the combination.
    
    Note:
    
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:
    
    Input: candidates = [10,1,2,7,6,1,5], target = 8,
    A solution set is:
    [
      [1, 7],
      [1, 2, 5],
      [2, 6],
      [1, 1, 6]
    ]
    Example 2:
    
    Input: candidates = [2,5,2,1,2], target = 5,
    A solution set is:
    [
      [1,2,2],
      [5]
    ]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs_com(0, target, candidates, res, tmp);
        return res;
    }
    
    public void dfs_com(int index, int target, int[] candidates, List<List<Integer>> res, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList(tmp));
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; i++) {
            
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (target < candidates[i]) break;
            tmp.add(candidates[i]);
            dfs_com(i + 1, target - candidates[i], candidates, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
