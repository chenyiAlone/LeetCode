package medium;
/**
 * 
 * ClassName: JumpGame
 * @author chenyiAlone  
 * Create Time: 2019/03/20 16:44:38
 * Description: No.55
 * 思路：
 *     首先想使用 DFS ,可这样当数组元素的值达到 n 的时候,最坏情况下的时间复杂度高达 2 ^ n ，这个做法不能满足题目的要求
 *     
 *     使用贪心算法，维持一个当前的最远路径
 *     
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
    
    Each element in the array represents your maximum jump length at that position.
    
    Determine if you are able to reach the last index.
    
    Example 1:
    
    Input: [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:
    
    Input: [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum
                 jump length is 0, which makes it impossible to reach the last index.    
 * 
 */
public class JumpGame {
    
    private boolean check = false;
    
    public boolean canJump(int[] nums) {
        int[] m = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            m[i] = nums[i] + i;
        }
        int longest = 0;
        for (int i = 0; i <= longest && longest <nums.length - 1; i++) {
            longest = Math.max(longest, m[i]);
        }
        return longest >= nums.length - 1;
    }
    
    public boolean canJump1(int[] nums) {
        if (nums.length < 2) return true;
        jumpDFS(0, nums);
        return check;
    }
    
    public void jumpDFS(int index, int[] nums) {
        if (index == nums.length - 1 || index + nums[index] >= nums.length - 1) {
            check = true;
            return;
        }
        if (index >= nums.length || nums[index] == 0 || check) {
            return;
        }
        for (int i = 1; i <= nums[index]; i++) {
            jumpDFS(index + i, nums);
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 0};
        System.out.println(new JumpGame().canJump(nums));
    }
}
