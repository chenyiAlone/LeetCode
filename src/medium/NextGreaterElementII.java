package medium;
/**
 * ClassName: NextGreaterElementII.java
 * Author: chenyiAlone
 * Create Time: 2019/9/22 20:48
 * Description: No.503 Next Greater Element II
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