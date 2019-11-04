package medium;
/**
 * ClassName: MaximumSwap.java
 * Author: chenyiAlone
 * Create Time: 2019/11/4 16:21
 * Description: No.670 Maximum Swap
 * 思路:
 *
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 *
 */
public class MaximumSwap {
    
    public int maximumSwap(int num) {
        StringBuilder s = new StringBuilder(Integer.toString(num));
        if (s.length() > 0) {
            int max = s.length() - 1, rmi = s.length() - 1, swi = s.length() - 1;
            for (int i = s.length() - 2; i >= 0; i--) {
                if (s.charAt(i) < s.charAt(max)) {
                    rmi = max;
                    swi = i;
                } else if (s.charAt(i) > s.charAt(max))
                    max = i;
            }
            char t = s.charAt(rmi);
            s.setCharAt(rmi, s.charAt(swi));
            s.setCharAt(swi, t);
        }
        return Integer.parseInt(s.toString());
    }

}