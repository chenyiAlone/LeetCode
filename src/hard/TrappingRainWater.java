package hard;

import java.util.Stack;

/**
 * 
 * ClassName: TrappingRainWater
 * @author chenyiAlone  
 * Create Time: 2019/01/26 21:52:56
 * Description: No.42
 * 总结:
 *     1. left, right 双指针向中间扫描
 *     2. 从height值小的一端向中间靠拢
 *     3. 更新 xxxMax 值，并累加到 res 中
 *     
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
    
    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
    
    Example:
    
    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
 */
public class TrappingRainWater {
    public int trap_Stack(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i ++) {
            if(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if(!stack.isEmpty()) {
                        res += (Math.min(height[stack.peek()], height[i]) - height[mid]) * (i - stack.peek() - 1);
                    }
                }
            }
            stack.push(i);
        }
        return res;
    }
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(new TrappingRainWater().trap(height));
        System.out.println(new TrappingRainWater().trap_Stack(height));
    }
}
