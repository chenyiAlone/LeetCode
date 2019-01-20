package hard;

import static util.Utils.*;

/**
 * 
 * ClassName: NextPermutation
 * @author chenyiAlone  
 * Create Time: 2019/01/20 15:38:50
 * Description: No.31
 * 示例：
 *     1, 2, 6, 5, 4
 *        ^
 *     1, 2, 6, 5, 4
 *        ^        *
 *     1, 4, 6, 5, 2
 *        *        ^
 *     1, 4, 2, 5, 6
 *        *        ^
 *     eg:
 *      ^ => firstSmall
 *      * => firstLarge
 *                 
 * 总结：
 *     1. 找到firstSmall 和 firstLarge
 *          * firstSmall 为从右向左第一个 nums[i] < nums[i + 1] 的数, 
 *          * firstLarge 为从右向左第一个大于 nums[firstSmall] 的数
 *     2. 将 nums[firstSmall 和 nums[firstLarge] 两个数组元素进行交换
 *     3. 将 nums 的从firstSmall + 1 到 nums.length - 1 区间进行转置  
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    
    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    
    The replacement must be in-place and use only constant extra memory.
    
    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
//        int[] nums = {3, 2, 1};
        new NextPermutation().nextPermutation(nums);
        printArray(nums);
    }
    public void nextPermutation(int[] nums) {
        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        System.out.println(firstSmall);
        if (firstSmall == -1) {
            reverseNums(nums, 0, nums.length - 1);
            return;
        }
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }
        System.out.println("firstSmall = " + firstSmall + "  firstLarge = " + firstLarge);
        exch(nums, firstSmall, firstLarge);
        reverseNums(nums, firstSmall + 1, nums.length - 1);
    }
    public static void reverseNums(int[] nums, int start, int end) {
        while (start < end) {
            exch(nums, start++, end--);
        }
    }
}
