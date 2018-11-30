package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * ClassName: ValidParentheses
 * @author chenyiAlone  
 * Create Time: 2018/11/30 13:10:57
 * Description: No.20  使用了LinkedList栈操作完成了匹配
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList stack = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
//                    System.out.println("c = " + c + "  match(c) = " + match(c) + " peek() = " + stack.peek());
                    if (stack.peek() == null || !stack.pop().equals(match(c)))
                        return false;
//                    System.out.println("执行这一句！！");
                    break;
            }
        }
        if (stack.size() == 0) return true;
        else return false;
    }
    
    public static char match(char c) {
        switch (c) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }
    
    public static void main(String[] args) {
        String s = "()";
        System.out.println(new ValidParentheses().isValid(s));
//        System.out.println(new Character('c').equals('c'));
    }
}
