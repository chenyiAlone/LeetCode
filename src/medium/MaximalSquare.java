package medium;

import java.util.Stack;
/**
 * ClassName: MaximalSquare.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/11 11:14
 * Description: No.221
 * 思路:
 *      1. 使用了 No.84 Largest Rectangle in Histogram 的解法
 *          1). stack store Non-descending array elements
 *          2). add a additional elements array[len] = 0 to pop all elements
 *              i. push element into stack if stack.isEmpty() or stack.peek() < array[i]
 *             ii. int width = 1;
 *                  while stack.isEmpty() && array[i] < stack.peek()
 *                     res = max(res, stack.pop() * width++);
 *                  while (width-- >= 1) stack.push(nums[i]);
 *
 *      2. 图示展示了插入在已经维持非降序的栈里插入一个 ^ 元素的时候的情况
 *
 *
 *    ^                           ^
 *    |                           |
 *    |           +               |
 *    |           |               |
 *    |        +  |               |
 *    |     +  |  |               |
 *    |     |  |  |  ^            |     +  +  +  ^
 *    |  +  |  |  |  |            |  +  |  |  |  |
 * +--+--+--+--+--+--+----->   +--+--+--+--+--+--+----->
 *
 *
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 *
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
//        if (m == 0)
//            return res;
        int n = (m == 0) ? 0 : matrix[0].length;
        if (n == 0)
            return res;

        int[] nums = new int[n + 1];

        for (char[] arr : matrix) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == '1') {
                    nums[i] += 1;
                } else {
                    nums[i] = 0;
                }
            }
            res = Math.max(res, arrayMaxSquare(nums));
        }
        return res;
    }
    /*

    1 0 1 0
    1 0 1 1
    1 0 1 1
    1 1 1 1

    */

    private int arrayMaxSquare(int[] nums) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty() || num > stack.peek()) {
                stack.push(num);
            } else {
                int width = 1;
                while (!stack.isEmpty() && num < stack.peek()) {
                    int height = stack.pop();
                    int side = Math.min(height, width++);
                    res = Math.max(res, side * side);
                }
                while (width-- >= 1)
                    stack.push(num);
            }
        }
        return res;
    }
}
