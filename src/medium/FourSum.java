package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * ClassName: FourSum
 * @author chenyiAlone  
 * Create Time: 2019/01/17 20:32:20
 * Description: No.18
 * 总结：
 *     1. 类似于3Sum的操作
 *     2. while只能放在 sum == target 的判断条件中
 *     
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
    
    Note:
    
    The solution set must not contain duplicate quadruplets.
    
    Example:
    
    Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
    
    A solution set is:
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int lo = j + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new FourSum().fourSum(nums, target));
    }
}
