package easy;
/**
 * 
 * ClassName: MoveZeroes
 * @author chenyiAlone  
 * Create Time: 2019/02/04 23:12:13
 * Description: No.283
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    
    Example:
    
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Note:
    
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int k = 0;
        int start = 0; 
        while (k < nums.length) {
            if (nums[k] != 0) {
                nums[start++] = nums[k];    
            }
            k++;
        }
        while (start < k) {
            nums[start++] = 0;
        }
    }
}
