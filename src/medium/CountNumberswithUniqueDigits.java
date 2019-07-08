package medium;
/**
 * ClassName: CountNumberswithUniqueDigits.java
 * Author: chenyiAlone
 * Create Time: 2019/7/8 17:36
 * Description: No.357 Count Numbers with Unique Digits
 */
public class CountNumberswithUniqueDigits {
    private int calA(int l, int r) {
        int ret = 1;
        for (int i = r; i > r - l; i--)
            ret *= i;
        return ret;
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int ret = 1;
        // System.out.println(calA(1, 9));        
        for (int i = 1; i <= Math.min(n, 10); i++)

            ret += 9 * calA(i - 1, 9);

        return ret;
    }
}