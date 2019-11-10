package easy;

/**
 * ClassName: FindPivotIndex.java
 * Author: chenyiAlone
 * Create Time: 2019/11/10 17:50
 * Description: No.724 Find Pivot Index
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len == 1 ? 0 : -1;
        int[] prev = new int[len], next = new int[len];
        prev[0] = nums[0];
        next[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++)
            prev[i] = prev[i - 1] + nums[i];
        for (int i = len - 2; i >= 0; i--)
            next[i] = next[i + 1] + nums[i];
        for (int i = 0; i < len; i++) {
            if (prev[i] == next[i])
                return i;
        }
        return -1;
        
    }

}