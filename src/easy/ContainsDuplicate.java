package easy;

import java.util.HashMap;
/**
 * 
 * ClassName: ContainsDuplicate
 * @author chenyiAlone  
 * Create Time: 2019/03/02 21:59:54
 * Description: No.217
 * Given an array of integers, find if the array contains any duplicates.
    
    Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
    
    Example 1:
    
    Input: [1,2,3,1]
    Output: true
    Example 2:
    
    Input: [1,2,3,4]
    Output: false
    Example 3:
    
    Input: [1,1,1,3,3,4,3,2,4,2]
    Output: true
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                
            } else if (nums[i] == max) {
                return true;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] == nums[j]) return true; 
                }
            }
        }
        return false;
    }
    public boolean containsDuplicateSlow(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > 1) return true; 
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}