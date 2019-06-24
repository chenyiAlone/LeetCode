package test.stack;

import java.util.Stack;
/**
 * ClassName: TestStack.java
 * Author: chenyiAlone
 * Create Time: 2019/6/24 12:02
 * Description: test stack
 *
 *      1. Integer 通过引用并不能改变对应在 stack 中的值
 *
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack  = new Stack<>();
        stack.push(0);
        Integer i = stack.peek();
        i = i + 1;
        System.out.println(stack.peek());
    }
}
