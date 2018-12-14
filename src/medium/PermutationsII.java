package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * ClassName: PermutationsII
 * @author chenyiAlone  
 * Create Time: 2018/12/14 10:35:40
 * Description: No.47  无重复的全排列,处理重复的时候的时间复杂度太差，基本可以废弃
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Integer[] ansInt = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ansInt[i] = Integer.valueOf(nums[i]);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        permute(ansInt, 0, ans);
        return ans;
        
    }
    public static void permute(Integer[] nums, int p, List<List<Integer>> list) {
        
        if (p == nums.length - 1) {
            List<Integer> ans = new ArrayList(Arrays.asList(nums));
            if (list.contains(ans)) {
                return;
            }
            list.add(ans);

        }
        
        for (int i = p; i < nums.length; i++) {
            Integer temp = nums[p];
            nums[p] = nums[i];
            nums[i] = temp;
            
            permute(nums, p + 1, list);
            
            temp = nums[p];
            nums[p] = nums[i];
            nums[i] = temp;
        }
    }
}
