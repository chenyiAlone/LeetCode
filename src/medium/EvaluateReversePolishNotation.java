package medium;

import java.util.LinkedList;
/**
 * 
 * ClassName: EvaluateReversePolishNotation
 * @author chenyiAlone  
 * Create Time: 2019/02/06 21:21:19
 * Description: No.150
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    
    Note:
    
    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
    Example 1:
    
    Input: ["2", "1", "+", "3", "*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9
    Example 2:
    
    Input: ["4", "13", "5", "/", "+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6
    Example 3:
    
    Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    Output: 22
    Explanation: 
      ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    = ((10 * (6 / (12 * -11))) + 17) + 5
    = ((10 * (6 / -132)) + 17) + 5
    = ((10 * 0) + 17) + 5
    = (0 + 17) + 5
    = 17 + 5
    = 22
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0 || tokens == null) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        while (i < tokens.length) {
            String s = tokens[i++];
            if (s.length() == 1) {
                if (s.charAt(0) == '+' ){
                    stack.push(stack.pop() + stack.pop());
                } else if (s.charAt(0) == '-') {
                    stack.push(-stack.pop() + stack.pop());
                } else if (s.charAt(0) == '*') {
                    stack.push(stack.pop() * stack.pop());
                } else if (s.charAt(0) == '/') {
                    int b = stack.pop(); 
                    int a = stack.pop();
                    stack.push(a / b);
                } else {
                    stack.push(Integer.parseInt(s));
                }    
            } else {
                stack.push(Integer.parseInt(s));
                
            }
            
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
        
    }
}