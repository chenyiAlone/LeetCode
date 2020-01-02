package easy;

/**
 * ClassName: LargestNumberAtLeastTwiceofOthers.java
 * Author: chenyiAlone
 * Create Time: 2019/1/2 22:56 
 * Description: No.747 Largest Number At Least Twice of Others
 */
public class LargestNumberAtLeastTwiceofOthers {

    public int dominantIndex(int[] nums) {
        int[] maxId = {-1, -1};
        if (nums.length < 2) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxId[0] == -1 || nums[i] > nums[maxId[0]]) {
                maxId[1] = maxId[0];
                maxId[0] = i;
            } else if (maxId[1] == -1 || nums[i] > nums[maxId[1]]) {
                maxId[1] = i;
            }
        }
        return nums[maxId[0]] >= nums[maxId[1]] * 2 ? maxId[0] : -1;
    }

}