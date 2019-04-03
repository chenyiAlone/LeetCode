package medium;

/**  
 * ClassName: SortColors
 * @author chenyiAlone  
 * Create Time: 2019/04/03 18:35:33
 * Description: No.75
 * 思路：
 *    1. color only three types, use three point to sort
 *    2. start=> 0, index=> 1, end=> 2
 *    3. After index swap with end, only end need ++; 
 *    
 *    
 *    
 *  Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
    
    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    
    Note: You are not suppose to use the library's sort function for this problem.
    
    Example:
    
    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    Follow up:
    
    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    Could you come up with a one-pass algorithm using only constant space?  
 *    
 */   
public class SortColors {
    public void sortColors(int[] nums) {
        int index = 0;
        int start = 0;
        int end = nums.length - 1;
        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, start, index);
                start++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, end);
                end--;
            }
        }
    }
    
    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}