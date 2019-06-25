package medium;

/**
 * ClassName: IncreasingTripletSubsequence.java
 * Author: chenyiAlone
 * Create Time: 2019/6/25 21:47
 * Description: No.334
 * 思路:
 *
 *      1. arr[3] = {max, max, max}保存三个值，arr[0] 为不存在解时最小的元素，arr[1] 为大于它的最小元素
 *      2. 更新条件
 *          - nums[i - 1] < arr[0]：当 nums[i - 1] 的值小于保存的最下值时更新 arr[0] = nums[i - 1]
 *          - nums[i] < arr[1] && arr[0] < nums[i]： 当 nums[i] 的值满足升序，并且小于 arr[1] 的值就更新 arr[1] = nums[i]
 *          - arr[2] = nums[i]：arr[i] 始终指向 nums[i + 1]
 *      3. 满足 arr[0] < arr[1] && arr[1] < arr[2] 的时候，return true
 *
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 *
 * Input: [5,4,3,2,1]
 * Output: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int len;
        int[] arr = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        if ((len = nums.length) < 3) return false;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i - 1] < arr[0]) arr[0] = nums[i - 1];
            if (arr[0] < nums[i] && arr[0] < nums[i]) arr[1] = nums[i];
            arr[2] = nums[i + 1];
            if (arr[0] < arr[1] && arr[1] < arr[2]) return true;
        }
        return false;
    }
}