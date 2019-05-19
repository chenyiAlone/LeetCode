package hard;
/**
 * ClassName: JumpGameII.java
 * Author: chenyiAlone
 * Create Time: 2019/5/19 14:54
 * Description: No.45
 * 思路:
 *      每次想最远的地方跳，更新为上一个位置的步数 + 1
 *      自己想出了更好的办法，看了看跟 Discuss 上的是一样的，可是没有实现，
 *      自己没能够捋出这个跳一次和上一次跳的最远距离之间的关系
 *
 *
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < len && f[i + j] == 0)
                    f[i + j] = f[i] + 1;
                if (f[len - 1] != 0)
                    return f[len - 1];
            }
        }
        return 0;
    }
    public int jumpFast(int[] nums) {
        int curEnd = 0;
        int curFarthest = 0;
        int jump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (curFarthest == nums.length - 1) {++jump;break;}
            if (i == curEnd) {
                curEnd = curFarthest;
                jump++;
            }
        }
        return jump;
    }
}
