package easy;

import java.util.*;

/**
 * ClassName: SumofSquareNumbers.java
 * Author: chenyiAlone
 * Create Time: 2019/1/14 22:28 
 * Description: No.633 Sum of Square Numbers
 */
public class SumofSquareNumbers {

    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c);
        while (l <= r) {
            if (l * l + r * r < c) l++;
            else if (l * l + r * r > c) r--;
            else return true;
        }
        return false;
    }

}