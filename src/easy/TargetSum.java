package easy;

/**
 * ClassName: .java
 * Author: chenyiAlone
 * Create Time: 2019/9/20 22:19
 * Description: No.494 Target Sum
 */
public class Solution {
    private int ret;
    private int[] arr;
    
    private void dfs(int index, int sum, int target) {
        if (index == arr.length) {
            if (index == arr.length && sum == target) ret++;
            return;
        }
        //for (int i = index; i < arr.length; i++) {
            dfs(index + 1, sum + arr[index], target);
            dfs(index + 1, sum - arr[index], target);
        //}
        
    }
    
    
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        arr = nums;
        dfs(0, 0, S);
        return ret;
        
    }
}