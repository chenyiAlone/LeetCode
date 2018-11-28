package easy;
import static util.Utils.*;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 *      Input: 123
 *      Output: 321
 * Example 2:
 *      Input: -123
 *      Output: -321
 * Example 3:
 *      Input: 120
 *      Output: 21
 * Note:
 *      Assume we are dealing with an environment which could only store integers 
 *      within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose 
 *      of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * @author chenyiAlone
 *
 */
public class ReverInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x !=0 ) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10) return 0;
            if (rev < Integer.MIN_VALUE/10) return 0;
            rev = rev*10 + pop;
        }
        return rev;
    }
    public int reverseByStringBuffer(int x) {
        StringBuffer sb  = x < 0 ? new StringBuffer(Integer.toString(x).substring(1)).append("-").reverse() : 
           new StringBuffer(Integer.toString(x)).reverse();
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        ReverInteger r = new ReverInteger();
        int[] array = new int[1];
//        array[2] = 1;
        int x = -65535;
//        System.out.println(Integer.toString(x));
//        String s = Integer.toString(x);
//        s = s.substring(1);
//        System.out.println(s);
//        StringBuffer sb = new StringBuffer(s).append("-").reverse();
        System.out.println(r.reverseByStringBuffer(x));
//        System.out.println(sb.toString());
    }
}

/* 
output:
-53556
 */
