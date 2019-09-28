package medium;

/**
 * ClassName: CoinChange2.java
 * Author: chenyiAlone
 * Create Time: 2019/9/ 
 * Description: No.518 CoinChange2
 */

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i : coins)
            for (int j = i; j <= amount; j++) {
                f[j] += f[j - i];
            }
        return f[amount];
    }
}