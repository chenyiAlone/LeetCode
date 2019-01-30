package hard;

import java.util.Stack;
import static util.Utils.*;
/**
 * 
 * ClassName: MaximalRectangle
 * @author chenyiAlone  
 * Create Time: 2019/01/30 16:00:52
 * Description: No.85
 * 总结: 
 *     1. 使用 heights[] 从上之下记录每行到首行的高度，转化为柱状图
 *     2. stack 中维持升序，碰到逆序 pop 求取面积
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
    
    Example:
    
    Input:
    [
      ["1","0","1","0","0"],
      ["1","0","1","1","1"],
      ["1","1","1","1","1"],
      ["1","0","0","1","0"]
    ]
    Output: 6
 * 
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[] heights = new int[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') heights[j] = 0;
                else heights[j]++;
            }
            printArray(heights);
            res = Math.max(res, maxArceHistogram(heights));
        }
        return res;
    }
    
    public static int maxArceHistogram(int[] heights) {
        int res = 0;
        int[] nums = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            nums[i] = heights[i];
        }
        nums[heights.length] = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] >= stack.peek()) {
                stack.push(nums[i]);
            } else {
                int width = 1;
                while (!stack.isEmpty() && nums[i] < stack.peek()) {
                    res = Math.max(res, width * stack.pop());
                    width++;
                }
                while (width-- >= 1) {  // 至少push一个
                    stack.push(nums[i]);
                }
            }
        }
        System.out.println(res);
        return res;
    }
    
    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {3, 1, 3, 2, 2};
        char[][] matrix = {
                    {'1','0','1','0','0'},
                    {'1','0','1','1','1'},
                    {'1','1','1','1','1'},
                    {'1','0','0','1','0'}
                          };
//        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
        maxArceHistogram(heights);
    }
}
