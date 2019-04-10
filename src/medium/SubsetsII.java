package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * ClassName: SubsetsII
 * @author chenyiAlone  
 * Create Time: 2019/04/10 17:10:44
 * Description: No.90
 * 思路：
 *   1. DFS + BackTracking
 *   2. sort(nums) 以便于跳过相同元素
 *   3. while () 用于跳过相同的元素，所有的迭代要求允许第一使用相同元素，同时跳过下一次使用的相同元素
 *      a. while 位于第一搜索之前，这样会让所有的元素只是用一次， 1 2 2 变为 1 2 的集合求结果
 *      b. while 位于第一次结束，第二次开始，这样第一次的搜索使用所有的元素 1 2 2，第二次的搜索使用不重复的元素 1 2
 *      
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
    
    Note: The solution set must not contain duplicate subsets.
    
    Example:
    
    Input: [1,2,2]
    Output:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ] 
 *      
 *      
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        dfs(0, res, temp, nums);
        return res;
    }
    private void dfs(int index, List<List<Integer>> res, List<Integer> temp, int[] nums) {
        res.add(new ArrayList<Integer>(temp));
        if (index == nums.length)
            return;
        while (index < nums.length) {
            while (index + 1 < nums.length && nums[index] == nums[index + 1])
                index++;
            temp.add(nums[index]);
            dfs(index + 1, res, temp, nums);
            temp.remove(temp.size() - 1);
            index++;
        }
    }
}