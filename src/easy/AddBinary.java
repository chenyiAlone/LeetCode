package easy;
/**
 * 
 * ClassName: AddBinary
 * @author chenyiAlone  
 * Create Time: 2018/12/27 22:54:31
 * Description: No.67 
 *  思路：
 *   1. 逆向遍历两个 str,直到两个字符串都到达 start
 *   2. car 用于记录进位，sum 用来计算当前位和进位的值，并更新当前位
 *   3. StringBuilder 反转数组
 *   
 * Given two binary strings, return their sum (also a binary string).

    The input strings are both non-empty and contains only characters 1 or 0.
    
    Example 1:
    
    Input: a = "11", b = "1"
    Output: "100"
    Example 2:
    
    Input: a = "1010", b = "1011"
    Output: "10101"
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int cy = 0;
        StringBuffer ans = new StringBuffer();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int num1 = 0, num2 = 0;
            if (i >= 0) num1 = a.charAt(i) - '0';
            if (j >= 0) num2 = b.charAt(j) - '0';
            int sum = num1 + num2 + cy;
            cy = sum / 2;
            ans.append(sum % 2);
            System.out.println(num1 + "+" + num2);
        }
        if (cy == 1) ans.append(cy);
        ans.reverse();
        return ans.toString();
    }
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(new AddBinary().addBinary(a, b));
    }
}
