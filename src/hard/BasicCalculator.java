package hard;

import java.util.Stack;
/**
 * ClassName: BasicCalculator.java
 * Author: chenyiAlone
 * Create Time: 2019/5/13 16:39
 * Description: No.224
 * 思路:
 *      1. 思路就是处理优先级的问题
 *      扫描到一个字符，就将 operate stack 中之前 连续的并且优先级相等或者更高的操作符 弹出并计算压入数组栈中
 *          `(` 的优先级最低
 *          `*` `/` 的优先级高于 `+` `-`
 *      2. 递归写法
 *
 *
 *
 *
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 *
 */
public class BasicCalculator {

    private char[] str;
    private int index;

    // 2. 递归写法
    private int cacul() {
        int ret = 0, flag = 1;
        while (index < str.length && str[index] != ')') {

            if ('0' <= str[index] && str[index] <= '9') {
                int num = 0;
                while (index < str.length && '0' <= str[index] && str[index] <= '9') {
                    num = num * 10 + str[index] - '0';
                    index++;
                }
                ret += flag * num;
            } else {
                switch(str[index++]) {
                    case '+':
                        flag = 1;
                        break;
                    case '-':
                        flag = -1;
                        break;
                    case '(':
                        ret += flag * cacul();
                        break;
                    case ' ':
                        break;
                }
            }
        }
        if (index < str.length && str[index] == ')') {
            index++;
        }
        return ret;
    }

    public int calculateByRec(String s) {
        str = s.toCharArray();
        return cacul();
    }

    // 1. 优先级递归
    private Stack<Integer> numbers = new Stack<>();
    private Stack<Character> operate = new Stack<>();

    public int calculate(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ')
                continue;

            if (isNumber(str[i])) {
                int N = str[i] - '0';
                while (i + 1 < len && isNumber(str[i + 1])) {
                    N = N * 10 + (str[i + 1] - '0');
                    i++;
                }
                numbers.push(N);
            } else {
                if (str[i] == ')') {
                    while (!operate.isEmpty() && operate.peek() != '(')
                        pop_operate();
                    operate.pop();  // pop '('
                } else {
                    if (str[i] == '+' || str[i] == '-') {
                        while (!operate.isEmpty() && operate.peek() != '(')
                            pop_operate();
                        operate.push(str[i]);
                    } else {
                        while (!operate.isEmpty() && (operate.peek() == '*' || operate.peek() == '/')  && operate.peek() != '(')
                            pop_operate();
                        operate.push(str[i]);
                    }
                }
            }
        }
        while (!operate.isEmpty())
            pop_operate();
        return numbers.pop();


    }
    private boolean isNumber(Character c) {
        return '0' <= c && c <= '9';
    }

    private void pop_operate() {
        int a = numbers.pop();
        int b = numbers.pop();
        char c = operate.pop();
        switch(c) {
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
}
