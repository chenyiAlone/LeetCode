package hard;

import java.util.Stack;
/**
 * 
 * ClassName: LargestRectangleinHistogram
 * @author chenyiAlone  
 * Create Time: 2019/01/28 16:17:30
 * Description: No.84
 * 总结:
 *     1. stack 中维持增序
 *     2. 元素小于stack栈顶元素， push 入栈
 *     3. 元素大于stack栈顶元素， pop 出栈顶元素直至大于栈顶元素
 *     4. 计算 pop 出所有元素的最大面积
 *     5. 最后的 0 能够将所有的元素 pop 求面积
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
    
    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
    
    The largest rectangle is shown in the shaded area, which has area = 10 unit.
    
    Example:
    
    Input: [2,1,5,6,2,3]
    Output: 10
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] nums = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            nums[i] = heights[i];
        }
        nums[heights.length] = 0;   // 用于清空stack，遍历
        Stack<Integer> stack = new Stack<>();   // stack 中维持一个增序
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] >= stack.peek()) {   // >= 
                stack.push(nums[i]);
            } else {
                int k = 1;
                while (!stack.isEmpty() && stack.peek() > nums[i]) {
                    int temp = stack.pop();
                    res = Math.max(res, k * temp);
                    k++;
                }
                while (k-- >= 1) {  // >= 1
                    stack.push(nums[i]);
                }
            }
        }
        return res;
    }
    /**
     * 暴力搜索
     * 时间：O(n^2)
     * @param heights
     * @return
     */
    public int largestRectangleArea_Slow(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length ; i++) {
            int k = i;
            int hi = Math.min(heights[i], heights[k]);
            while (k < heights.length) {
                hi = Math.min(hi, heights[k]);
                res = Math.max(res, (k - i + 1) * hi);
                k++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] heights = {1, 1};
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(heights));
    }
}
