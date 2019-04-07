package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: Subsets
 * @author chenyiAlone  
 * Create Time: 2019/04/07 22:58:10
 * Description: No.78
 * 思路：
 *    1. 移位操作
 *        1). maxi = 1 << len;
 *        2). i = 0 -> maxi
 *            j = 0 -> size
 *        3). ((1 << j) & i) != 0
 *    
 *    2. DFS
 * 
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
    
    Note: The solution set must not contain duplicate subsets.
    
    Example:
    
    Input: nums = [1,2,3]
    Output:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int maxi = 1 << len;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < maxi; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (((1 << j) & i) != 0) {
                    tmp.add(nums[j]);
                }
            }
            res.add(new ArrayList<Integer>(tmp));
        }
        return res;
    }
}