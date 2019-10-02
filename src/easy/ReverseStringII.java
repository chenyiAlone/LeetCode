package easy;

/**
 * ClassName: Reverse String II.java
 * Author: chenyiAlone
 * Create Time: 2019/10/2 21:42
 * Description: No.541 Reverse String II
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i * 2 * k < s.length(); i++) {
            for (int j = (i + 1) * 2 * k - k - 1, index = i * 2 * k; j >= i * 2 * k; j--)
                if (j < s.length())
                    str.setCharAt(index++, s.charAt(j));
        }
        return str.toString();
    }
}