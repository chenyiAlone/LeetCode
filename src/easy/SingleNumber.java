package easy;

import java.util.HashMap;
/**
 * 
 * ClassName: SingleNumber
 * @author chenyiAlone  
 * Create Time: 2018/12/29 09:22:12
 * Description: No.136
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note:
    
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    
    Example 1:
    
    Input: [2,2,1]
    Output: 1
    Example 2:
    
    Input: [4,1,2,1,2]
    Output: 4
 */
public class SingleNumber {
    // 使用HashMap
    // 时间复杂度 O(n)
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : nums) {
            if (map.get(i) == 1) return i;
        }
        return -1;
    }
    
    // 暴力搜索
    // 时间复杂度 O(n^2)
    public int singleNumber1(int[] nums) {
        int[] size = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    size[j]++;
                    size[i]++;
                }
            }
        }
        for (int i = 0; i < size.length; i++) {
            if (size[i] == 0) return nums[i];
        }
        return -1;
    }
}
