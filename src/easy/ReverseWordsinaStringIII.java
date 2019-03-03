package easy;

import java.util.Stack;
/**
 * 
 * ClassName: ReverseWordsinaStringIII
 * @author chenyiAlone  
 * Create Time: 2019/03/03 21:19:16
 * Description: No.557
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
    
    Example 1:
    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
    Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0, len = s.length();
        while (start < len) {
            int end = s.indexOf(' ', start);
            if (end == -1) {
                hander(arr, start, len - 1);
                break;
            } else {
                hander(arr, start, end - 1);
                start = end + 1;
            }
        }
        return String.valueOf(arr);
    }
    public static void hander(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }
    public String reverseWordsStack(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                stack.push(s.charAt(i));
            } else {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new ReverseWordsinaStringIII().reverseWords(s));
    }
}