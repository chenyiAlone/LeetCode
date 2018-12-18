package easy;
/**
 * 
 * ClassName: MaximumSubarray
 * @author chenyiAlone  
 * Create Time: 2018/12/18 21:09:09
 * Description: No.53 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:
    
    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            ans = Math.max(temp, ans);
            for (int j= i + 1; j <nums.length; j++) {
                temp += nums[j];
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-2, 1};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
