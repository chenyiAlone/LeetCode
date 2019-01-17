package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static util.Utils.*;

/**
 * 
 * ClassName: ThreeSum
 * @author chenyiAlone  
 * Create Time: 2018/11/30 12:26:28
 * Description: No.15 勉强通过，时间复杂度太差
 * 
 * update 2019/1/17:
 *  1. 将数组首先进行排序
 *  2. 使用双指针lo, hi双向扫描，while将相同结果跳过
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        printArray(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] < sum) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }
    
	public List<List<Integer>> threeSum_Low(int[] nums) {
	    Arrays.sort(nums);
		int lo = 0, hi = nums.length - 1;
		List<List<Integer>> ans = new ArrayList<>();
		printArray(nums);
		for (int i = 0; i < nums.length - 2; i++) {
		    if (i > 0 && nums[i] == nums[i-1]) continue;
			for (int j = i + 1; j < nums.length - 1; j++) {
				int seek = -(nums[i] + nums[j]);
				lo = j + 1;
				hi = nums.length - 1;
				int mid = 0;
				boolean hasTriplets = false, hasRep = false;
				while (lo <= hi) {
					mid = (lo + hi) / 2;
					if 		(nums[mid] < seek) lo = mid + 1;
					else if (seek < nums[mid]) hi = mid - 1;
					else { hasTriplets = true; break; }
				}
				if (hasTriplets) {

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[mid]);
                    if (ans.size() == 0) {
                        ans.add(list);
                    } else if (!ans.get(ans.size() - 1).equals(list)) { 
                        ans.add(list);
                    }   
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums2 = {-2, 0, 1, 1, 2};
        System.out.println(new ThreeSum().threeSum(nums2));
    }
	
}
