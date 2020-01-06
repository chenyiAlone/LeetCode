package easy;

/**
 * ClassName: NthTribonacciNumber.java
 * Author: chenyiAlone
 * Create Time: 2019/1/6 21:40 
 * Description: No.1137 N-th Tribonacci Number
 */
public class NthTribonacciNumber {

    public int tribonacci(int n) {
        int ret = 0;
        int[] cnt = {0, 1, 1};
        if (n < 3) return cnt[n];
        for (int i = 2; i < n; i++) {
            ret = cnt[0] + cnt[1] + cnt[2];
            cnt[0] = cnt[1];
            cnt[1] = cnt[2];
            cnt[2] = ret;
        }
        return ret;
    }

}