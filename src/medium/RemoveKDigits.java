package medium;

import java.util.LinkedList;
/**
 * ClassName: RemoveKDigits.java
 * Author: chenyiAlone
 * Create Time: 2019/5/25 14:12
 * Description: No.402
 * 思路:
 *      1. 删除的位数是固定的，也就是剩下的位数是固定的
 *      2. 只要前面的数比后面的小，那这个结果一定小
 * eg:
 *      123456, k = 2; => 从最后开始删除
 *      1234
 *
 *      102435, k = 2; => 维持一个增序
 *      0235
 *
 *
 *
 * 删除的位数是固定的，也就是剩下的位数是固定的
 * 只要前面的数比后面的小，那这个结果一定小
 * 123456, k = 2; => 从最后开始删除
 * 1234
 *
 * 102435, k = 2; => 维持一个增序
 * 0235
 *
 *
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (char c : num.toCharArray()) {
            int i = c - '0';
            while (!stack.isEmpty() && stack.peek() > i && k != 0) {
                stack.pop();
                k --;
            }
            stack.push(i);
        }
        while (k-- != 0)
            stack.pop();
        while (stack.size() > 1 && stack.peekLast() == 0)
            stack.pollLast();
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pollLast());
        return res.length() == 0 ? "0" : res.toString();
    }
}
