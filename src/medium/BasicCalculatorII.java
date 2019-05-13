package medium;

import java.util.Stack;
/**
 * ClassName: BasicCalculatorII.java
 * Author: chenyiAlone
 * Create Time: 2019/5/13 16:50
 * Description: No.227
 * 思路:
 *      1. 需要处理符号优先级的问题，+ - 的优先级最低，* / 的优先级相对较高，每次入栈之前需要将所有的优先级相同的 operate 出栈
 *          并且计算出值加入到 number 栈中
 *      2. 特别需要注意 if 千万不要写成 while 不然会一直卡在 while (true) continue;
 *          for (int i : nums) {
 *              if (i == x)
 *                  continue;
 *          }
 *
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 */
public class BasicCalculatorII {

    private Stack<Integer> numbers = new Stack<>();
    private Stack<Character> operate = new Stack<>();

    private boolean isNumber(Character c) {
        return '0' <= c && c <= '9';
    }

    private void pop_operate() {
        int a = numbers.pop();
        int b = numbers.pop();
        switch(operate.pop()) {
            case '+':
                numbers.push(a + b);
                break;
            case '-':
                numbers.push(b - a);
                break;
            case '*':
                numbers.push(a * b);
                break;
            case '/':
                numbers.push(b / a);
                break;
            default:
                break;
        }
    }

    public int calculate(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ')
                continue;

            if (isNumber(str[i])) {
                int N = str[i] - '0';
                while (i + 1 < len && isNumber(str[i + 1])) {
                    N = N * 10 + str[i + 1] - '0';
                    i++;
                }
                numbers.push(N);
            } else {
                // 2 * 3 + 1 / 2 = 6;
                if (str[i] == '+' || str[i] == '-') {
                    while (!operate.isEmpty())
                        pop_operate();
                    operate.push(str[i]);
                } else {
                    while (!operate.isEmpty() && (operate.peek() == '*' || operate.peek() == '/'))
                        pop_operate();

                    operate.push(str[i]);
                }
                //
            }
        }
        while (!operate.isEmpty())
            pop_operate();
        return numbers.pop();
    }
}
