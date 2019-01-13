package easy;
/**
 * 
 * ClassName: RotateArray
 * @author chenyiAlone  
 * Create Time: 2019/01/13 21:05:23
 * Description: No.189
 *      要求空间复杂度为O(1)
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

    Example 1:
    
    Input: [1,2,3,4,5,6,7] and k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    Example 2:
    
    Input: [-1,-100,3,99] and k = 2
    Output: [3,99,-1,-100]
    Explanation: 
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
    Note:
    
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    // 使用一个大小为k的数组
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] copy = new int[k];
        for (int i = nums.length - k, j = 0; i < nums.length; i++, j++) {
            copy[j] = nums[i];
        }
        for (int i = nums.length - 1, j = nums.length - k - 1; j >= 0; i--, j--) {
            nums[i] = nums[j];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = copy[i];
        }
    }
    // 通过平移k次数组
    public void rotate_low(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
