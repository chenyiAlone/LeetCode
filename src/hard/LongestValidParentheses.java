package hard;

import java.util.LinkedList;

/**
 * 
 * ClassName: LongestValidParentheses
 * @author chenyiAlone  
 * Create Time: 2018/12/13 08:41:21
 * Description: No.32 暂时未完成...
 */
public class LongestValidParentheses {
    
    public int longestValidParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int ans = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(i);
            Character c = s.charAt(i);
            System.out.println("c = " + c);
            if (c.charValue() == '(') {
                if (flag) {
                    flag = !flag;
                } else {
                    ans = Math.max(ans, count);
                    count = 0;
                }
                stack.push(c);
            } else if (c.charValue() == ')') {
                Character headC = stack.peek();
                System.out.println("headC = " + headC);
                if (headC != null && headC.charValue() == '(') {
                    stack.pop();
                    count += 2;
                    flag = true;
                } else {
                    ans = Math.max(ans, count);
                    count = 0;
                    stack.push(c);
                    flag = false;
                }
                System.out.println("ans" + ans);
//                System.out.println("i = " + i + "  c = " + c  + "  headC = " + stack.peek() + "  stack = " + stack);
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }
    
    /*
    public int longestValidParentheses(String s) {
        int count = 0, ans = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            System.out.println(c + "" + list.peek());
            if (c.equals('('))
                list.offer(c);
            else if (c.equals(')')) {
                if (Character.valueOf('(').equals(list.peek())) {
                    list.pop();
                    count += 2;
                    ans = Math.max(count, ans);
                } else {
                    count = 0;
                }
            }
        }
        return ans;
    }*/
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println("ans = " +new LongestValidParentheses().longestValidParentheses(s));
    }
    
}
