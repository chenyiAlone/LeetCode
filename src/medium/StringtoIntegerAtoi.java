package medium;
/**
 * 
 * ClassName: StringtoIntegerAtoi
 * @author chenyiAlone  
 * Create Time: 2018/12/15 15:01:32
 * Description: No.8
 */
public class StringtoIntegerAtoi {
    // +-  越界 
    public int myAtoi(String str) {
        
        int sign = 1;
        int start = 0;
        long ans = 0;
        
        str = str.trim();
        if (str.length() == 0 || str == null) return 0; // 必须放在取出首位空字符之后
        char firstChar = str.charAt(0);
        if (firstChar == '-') {
            sign = -1;
            start++;
        } else if (firstChar == '+'){
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int)ans * sign;
            }
            ans = ans * 10 + (str.charAt(i) - '0');
            if (sign == 1 && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && ans * -1 < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        
        return (int)ans * sign;
    }
    public static void main(String[] args) {
        String str = "";
        System.out.println(str.charAt(1));
        System.out.println(str.length());
        System.out.println(new StringtoIntegerAtoi().myAtoi(str));
    }
}
