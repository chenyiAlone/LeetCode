package easy;

import java.uitl.*;

/**
 * ClassName: SelftDividingNumbers.java
 * Author: chenyiAlone
 * Create Time: 2019/11/18 22:20
 * Description: No.728 Selft Dividing Numbers
 */
public class SelftDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String ns = Integer.toString(i);
            boolean can = true;
            for (char c : ns.toCharArray()) {
                int div = c - '0';
                if (div == 0 || i % div != 0) {
                    can = false;
                    break;
                }
            }
            if (can) ret.add(i);
        }
        return ret;
    }
}