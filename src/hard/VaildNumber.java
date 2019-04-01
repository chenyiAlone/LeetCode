package hard;
/**
 * 
 * ClassName: VaildNumber
 * @author chenyiAlone  
 * Create Time: 2019/04/01 17:49:28
 * Description: No.65
 * 思路：
 *    1. 坑就是这个题目要求的 .1 和 1. 这种数是 true， e 前面可以为小数，后面必须为整数，而且可以有符号
 *    2. 最麻烦的情况就是 e 的判断，只需要进行 _(+/-小数) e_(+/-整数) 的判断方法即可
 *    3. 小数的判断方法 match(String s, int start, int end)，当失配的时候就返回 -1
 * 
 * 
 * Validate if a given string can be interpreted as a decimal number.
    
    Some examples:
    "0" => true
    " 0.1 " => true
    "abc" => false
    "1 a" => false
    "2e10" => true
    " -90e3   " => true
    " 1e" => false
    "e3" => false
    " 6e-1" => true
    " 99e2.5 " => false
    "53.5e93" => true
    " --6 " => false
    "-+3" => false
    "95a54e53" => false
    
    Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
    
    Numbers 0-9
    Exponent - "e"
    Positive/negative sign - "+"/"-"
    Decimal point - "."
    Of course, the context of these characters also matters in the input.
    
    Update (2015-02-10):
    The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */
public class VaildNumber {
    public static void main(String[] args) {
        String s = " 005047e+6";
        System.out.println(new VaildNumber().isNumber(s));
    }
    private int match(String s, int start, int end) {
        int lcount = 0, rcount = 0;
        while (start <= end && s.charAt(start) <='9' && s.charAt(start) >= '0') {
            start++;
            lcount++;
        }
        if (start <= end && s.charAt(start) == '.') {
            start++;
            while (start <= end && s.charAt(start) <='9' && s.charAt(start) >= '0') {
                rcount++;
                start++;
            }
        }
        if (lcount == 0 && rcount == 0)
            return -1;
        return start - 1;
    }
    
    private int matchAfter(String s, int start, int end) {
        int count = 0;
        while (start <= end && s.charAt(start) <='9' && s.charAt(start) >= '0') {
            start++;
            count++;
        }
        if (count == 0)
            return -1;
        return start - 1;
    }
    
    public boolean isNumber(String s) {
        int len = s.length();
        int start = 0, end = len - 1;
        while (start < len && s.charAt(start) == ' ') start++;
        while (0 < end && s.charAt(end) == ' ') end--;
        // "  "
        if (start > end)
            return false;
        if (s.charAt(start) == '+' || s.charAt(start) == '-')
            start++;
        start = match(s, start, end);
        if (start == -1)
            return false;
        // 0 1 2 3 4 
        // 1 0 e 2 1
        if (start < end && s.charAt(start + 1) == 'e') {
            if (start + 2 > end)
                return false;
            start += 2;
            if (s.charAt(start) == '+' || s.charAt(start) == '-')
                start++;
            
            start = matchAfter(s, start, end);
            if (start == -1)
                return false;
        }
        if (start < end)
            return false;
        return true;
    }
}