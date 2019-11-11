package medium;
/**
 * ClassName: TotalHammingDistance.java
 * Author: chenyiAlone
 * Create Time: 2019/11/11 17:15
 * Description: No.477 Total Hamming Distance
 * 思路:
 *      total = cnt[i] * (len - cnt[i]), cnt[i] 表示第 i 位上的 1 的个数
 *
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 *
 * Example:
 * Input: 4, 14, 2
 *
 * Output: 6
 *
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * Note:
 * Elements of the given array are in the range of 0 to 10^9
 * Length of the array will not exceed 10^4.
 *
 */
public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int ret = 0;
        int[] cnt = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; nums[i] > 0 && j < 32; j++) {
                cnt[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            ret += cnt[i] * (nums.length - cnt[i]);
        }
        return ret;
    }

}