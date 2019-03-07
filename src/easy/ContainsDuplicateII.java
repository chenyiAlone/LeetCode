package easy;
/**
 * 
 * ClassName: ContainsDuplicateII
 * @author chenyiAlone  
 * Create Time: 2019/03/07 17:28:42
 * Description: No.219
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
    
    Example 1:
    
    Input: nums = [1,2,3,1], k = 3
    Output: true
    Example 2:
    
    Input: nums = [1,0,1,1], k = 1
    Output: true
    Example 3:
    
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = (i - k) < 0 ? 0 : i - k; j < i; j++) {
                if (nums[i] == nums[j]) {
                    System.out.println(i + " " + j);
                    return true;   
                }
            }
        }
        return false;
    }
}
