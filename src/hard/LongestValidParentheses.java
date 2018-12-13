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
    }
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
    */
}
