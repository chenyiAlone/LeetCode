package medium;
/**
 * ClassName: AdditiveNumber.java
 * Author: chenyiAlone
 * Create Time: 2019/5/23 16:48
 * Description: No.306
 * 思路:
 *
 *  (num.charAt(fbegin) == '0' && fbegin != fend) || (fend + 1 < len && num.charAt(fend + 1) == '0' && fend + 1 != send) 排除前导 0x，0 有效
 * 更新示例
 * // 112358
 *
 *       fbegin: 0 1
 *         fend: 0 1
 *         send: 1 2
 *       ansLen: 1
 *
 *
 */
public class AdditiveNumber {
    private String add(String s1, String s2) {
        StringBuilder ans = new StringBuilder();
        int c = 0;
        int p1 = s1.length() - 1, p2 = s2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int a = p1 < 0 ? 0 : s1.charAt(p1--) - '0';
            int b = p2 < 0 ? 0 : s2.charAt(p2--) - '0';
            int sum  = a + b + c;
            ans.append(sum % 10);
            c = sum / 10;
        }
        if (c > 0)
            ans.append(c);
        return ans.reverse().toString();
    }

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for(int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                int fbegin = 0, fend = i, send = j;
                while (true) {
                    String s1 = num.substring(fbegin, fend + 1);
                    String s2 = num.substring(fend + 1, send + 1);
                    // System.out.println(s1 + " + " + s2);
                    String ans = add(s1, s2);
                    // 1 2 3
                    // 112358
                    /*
                    fbegin: 0 1
                      fend: 0 1
                      send: 1 2
                    ansLen: 1
                    */
                    // System.out.println(s1 + " + " + s2 + " = " + ans);
                    if ((num.charAt(fbegin) == '0' && fbegin != fend) || (fend + 1 < len && num.charAt(fend + 1) == '0' && fend + 1 != send))
                        break;
                    if (send + ans.length() < len) {
                        if (num.substring(send + 1, send + 1 + ans.length()).equals(ans)) {
                            if (send + 1 + ans.length() == len)
                                return true;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                    fbegin = fend + 1;
                    fend = send;
                    send = send + ans.length();
                }
            }
        return false;
    }
}