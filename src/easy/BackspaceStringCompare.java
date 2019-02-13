package easy;

import java.util.Stack;
/**
 * 
 * ClassName: BackspaceStringCompare
 * @author chenyiAlone  
 * Create Time: 2019/02/13 20:07:35
 * Description: No.844
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
    
    Example 1:
    
    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".
    Example 2:
    
    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".
    Example 3:
    
    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".
    Example 4:
    
    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".
    Note:
    
    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.

 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!stack1.isEmpty()) stack1.pop();
            } else {
                stack1.push(c);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (!stack2.isEmpty()) stack2.pop();
            } else {
                stack2.push(c);
            }
        }
        return stack1.equals(stack2);
    }
}