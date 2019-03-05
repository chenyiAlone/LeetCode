package medium;
/**
 * 
 * ClassName: ProductofArrayExceptSelf
 * @author chenyiAlone  
 * Create Time: 2019/03/05 19:46:31
 * Description: No.238
 * 总结:
 *     第一遍用除法做了没看到题目中的要求，确实是没绕过这个弯来
 *     
 *     1. 思路为当前项的结果为前所有项之积乘上后面所有项之积
 *     2. 使用 p 将 output[] 的每项储存当前项之前的所有项之积
 *     3. 使用 p 反向存储当前项之后的所有项之积
 *     
 *     
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Example:
    
    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Note: Please solve it without division and in O(n).
    
    Follow up:
    Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
    public int[] prductExceptSlefDivision(int[] nums) {
        int[] output = new int[nums.length];
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = p; 
            p *= nums[i];
        }
        p = 1; 
        for (int i = nums.length - 1; i >= 0; i++) {
            output[i] *= p;
            p *= nums[i];
        }
        return output;
    }
    public int[] productExceptSelfDivision(int[] nums) {
        int res = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) res *= nums[i];
            else zeroCount++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeroCount == 1 ) nums[i] = res;
            else if (nums[i] != 0 && zeroCount == 0) nums[i] = res / nums[i];
            else nums[i] = 0;
        }
        return nums;
    }
}