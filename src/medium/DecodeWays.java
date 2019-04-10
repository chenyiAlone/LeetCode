package medium;
/**
 * 
 * ClassName: DecodeWays
 * @author chenyiAlone  
 * Create Time: 2019/04/10 17:55:17
 * Description: No.91
 * 思路:
 *   1. 当不为 '0' ，最少的种类为 1
 *   2. 判断当前位是否为 '0', 否则将这个位置的值更新为上一个状态
 *   3. 当前位不为 '0' 并且下一位和该位的值 小于26 那么这两个数就有两种状态
 * 
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        int[] f = new int[len + 1];
        f[0] = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '0') {
                f[i + 1] += f[i];
                if (i + 1 < len && 10 * (s.charAt(i) - '0') + s.charAt(i + 1) - '0' <= 26)
                    f[i + 2] += f[i];
            }
        }
        return f[len];
    }
}