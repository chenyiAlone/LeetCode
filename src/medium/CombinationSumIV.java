package medium;

/**
 * ClassName: CombinationSumIV.java
 * Author: chenyiAlone
 * Create Time: 2019/11/30 22:17 
 * Description: No.377 Combination Sum IV
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < target; i++)
            if (f[i] > 0)
                for (int j : nums)
                    if (i + j <= target)
                        f[i + j] += f[i];
        return f[target];
    }
    
}