package medium;

/**
 * @author chenyiAlone
 * @date 2020/10/20 09:30
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 *
 * 思路:
 *
 * 将所有的数字异或完成后会得到两个只出现一次的数字进行异或的结果，异或的结果代表这两个数字不同的位，
 * 因为其他的数字都出现了两次，根据异或结果的随便一位进行分组，相同的数字肯定会分在一组，不会对结果
 * 产生影响，所以两个分组中就分别包含了只出现的一次的数字，两组异或完成的结果就是答案
 *
 *
 */
public class Offer56 {

    public int[] singleNumbers(int[] nums) {
        int ret = 0, div = 1, a = 0, b = 0;
        for (int n : nums) {
            ret ^= n;
        }
        while ((div & ret) == 0) {
            div <<=1 ;
        }
        for (int n : nums) {
            if ((n & div) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

}
