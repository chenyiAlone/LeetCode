package hard;

/**  
 * ClassName: FirstMissingPositive
 * @author chenyiAlone  
 * Create Time: 2019/03/21 15:22:17
 * Description: No.41
 * 思路：
 *    1. 如果当前数的值大于0 && 小于数组长度 && 不等于以该数组值为下标的数组元素，就进行 swap
 *    2. 遍历数组，返回第一个值不等于(当前下标 + 1) 的 (元素下标 + 1) 即第一个缺失的正整数
 *    
 *    
 * Given an unsorted integer array, find the smallest missing positive integer.
    1
    Example 1:
    
    Input: [1,2,0]
    Output: 3
    Example 2:
    
    Input: [3,4,-1,1]
    Output: 2
    Example 3:
    
    Input: [7,8,9,11,12]
    Output: 1
    Note:
    
    Your algorithm should run in O(n) time and uses constant extra space.
 */   
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        int index = 0;
        while (index < nums.length && nums[index] == index + 1) {
            index++;
        }
        return index + 1;
    }
}
