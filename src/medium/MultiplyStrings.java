package medium;
/**
 * ClassName: MultiplyStrings.java
 * Author: chenyiAlone
 * Create Time: 2019/5/19 14:02
 * Description: No.8
 * 思路:
 *      1. 模拟乘法运算
 *      2. 如果第一位为 0 return 0
 *      3. subMul 部分积和 ans 都反向保存，return 时 reverse()
 *
 *
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Accepted
 *
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        StringBuilder subMul = new StringBuilder();
        int p = 0;
        for (int i = n2; i >= 0; i--) {
            int c = 0;
            subMul.setLength(0);
            for (int j = n1; j >= 0; j--) {
                int mul = (c + (num1.charAt(j) - '0') * (num2.charAt(i) - '0'));
                subMul.append(mul % 10);
                c = mul / 10;
            }
            if (c != 0)
                subMul.append(c);
            int l = 0, index = p;
            c = 0;
            while (l < subMul.length()) {
                int a = p + l < ans.length() ? ans.charAt(p + l) - '0' : 0;
                int b = l < subMul.length() ? subMul.charAt(l) - '0' : 0;
                while (ans.length() < p + l)
                    ans.append(0);
                if (ans.length() == p + l)
                    ans.append((a + b + c) % 10);
                else
                    ans.setCharAt(index++, (char)('0' + (a + b + c) % 10));
                c = (c + a + b) / 10;

                l++;
            }
            if (c != 0)
                ans.append(c);
            p++;

        }
        return (ans.charAt(ans.length() - 1) == '0') ? "0" : ans.reverse().toString();
    }



    private String multiplyOld(String num1, String num2) {
        StringBuffer ans = new StringBuffer("0");
        for (int i = 0; i < num2.length(); i++) {
//            char c = 10;
            String sumApart = num1;
            StringBuffer temp = new StringBuffer();
            multiplySingle(sumApart, num2.charAt(i), temp, sumApart.length() - 1, 0);
            for (int j = 0; j < i; j++) {
                temp.append("0");
            }
            System.out.println("sumApart = " + sumApart + "  temp = " + temp);
            addSB(temp, ans);
//            ans.append("0");
            
        }
//        ans.setLength(ans.length() - 1);
        return ans.toString();
    }
    public static void addSB(StringBuffer temp, StringBuffer ans) {
        String sumApartStr = temp.toString();
        String ansStr = ans.toString();
//        int i = Math.max(temp.length(), ans.length());
        int cy = 0;
        ans.setLength(0);
        System.out.println("方法中的 sum = " + sumApartStr + "  ansStr = " + ansStr);
        for (int i = sumApartStr.length() - 1, j = ansStr.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int num1 = 0, num2 = 0;
            if (i >= 0) num1 = sumApartStr.charAt(i) - '0';
            if (j >= 0) num2 = ansStr.charAt(j) - '0';
            int sum = num1 + num2 + cy;
            cy = sum / 10;
            ans.append("" + sum % 10);
        }
        if (cy != 0) ans.append("" + cy);
        ans.reverse();
        System.out.println("方法中" + ans);
    }
    
    public static void multiplySingle(String num, char numSingle, StringBuffer sb, int n, int cy) {
        if (numSingle == '0' || num.charAt(0) == '0') {
            sb = new StringBuffer("0");
            return;
        }
        if (n == 0) {
            sb.append("" + ((num.charAt(n) - '0') * (numSingle - '0') + cy));
            return;
        }
        int sum = (num.charAt(n) - '0') * (numSingle - '0') + cy;
        System.out.println("sum = " + sum);
        int bit = sum % 10;
        cy = sum /10;
        multiplySingle(num, numSingle, sb, n -1, cy);
        sb.append(bit);
    }
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "9";
//        StringBuffer sb1 = new StringBuffer(num1);
//        StringBuffer sb2 = new StringBuffer(num2);
//        addSB(sb1, sb2);
//        System.out.println(sb2);
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
    
}
