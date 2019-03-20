package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: CombinationSum
 * @author chenyiAlone  
 * Create Time: 2019/03/20 16:33:19
 * Description: No.39
 * 思路：
 *     DFS 深度优先搜索 + BackTracing 回溯算法
 * 重点：
 *     BackTracing 中的回溯是重点，在尝试失败退回的时候需要将这个尝试的对象更改会原来的状态，
 *     也就是这里 tmp 临时 List 在尝试 加入 candidates[i] 后需要将这个对象褪出，每次回褪褪出
 *     当前递归层添加的对象即可，也就是 List 的末尾元素
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
    
    The same repeated number may be chosen from candidates unlimited number of times.
    
    Note:
    
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:
    
    Input: candidates = [2,3,6,7], target = 7,
    A solution set is:
    [
      [7],
      [2,2,3]
    ]
    Example 2:
    
    Input: candidates = [2,3,5], target = 8,
    A solution set is:
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]
 * 
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs_com(0, target, candidates, res, tmp);
        return res;
     }
    
    public void dfs_com(int index, int target, int[] candidates, List<List<Integer>> res, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) return;
            tmp.add(candidates[i]);
            dfs_com(i, target - candidates[i], candidates, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = new CombinationSum().combinationSum(candidates, target);
        System.out.println(res);
    }
}
