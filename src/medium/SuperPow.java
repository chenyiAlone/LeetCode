package medium;

/**
 * ClassName: SuperPow.java
 * Author: chenyiAlone
 * Create Time: 2019/11/19 21:30 
 * Description: No.372 Super Pow
 */
public class SuperPow {

    public int superPow(int a, int[] b) {
        int mod = 1337;
        a %= mod;
        int ret = 1;
        int l = 0, r = b.length - 1;
        for (int mul = a; l <=r; mul = mul * mul % mod) {
            if ((b[r] & 1) == 1) ret = ret * mul % mod;
            int inc = 0, newInc = 0;
            for (int i = l; i <= r; i++, newInc = 0) {
                if ((b[i] + inc * 10) % 2 == 1) newInc = 1;
                b[i] = (b[i] + inc * 10) / 2;
                inc = newInc;
            }
            while (l <= r && b[l] == 0) l++;
        }
        
        return ret;
    }

}