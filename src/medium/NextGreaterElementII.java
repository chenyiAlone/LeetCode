package medium;
/**
 * ClassName: NextGreaterElementII.java
 * Author: chenyiAlone
 * Create Time: 2019/9/22 20:48
 * Description: No.503 Next Greater Element II
 *
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 *
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = arr[i + nums.length] = nums[i];
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = -1;
            for (int j = i + 1; j < i + nums.length; j++) {
                if (arr[j] > arr[i]) {
                    ret[i] = arr[j];
                    break;
                }
            }
        }
        return ret;
    }
    
}