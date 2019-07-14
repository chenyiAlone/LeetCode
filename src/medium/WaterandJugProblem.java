package medium;
/**
 * ClassName: WaterandJugProblem.java
 * Author: chenyiAlone
 * Create Time: 2019/7/14 10:21
 * Description: No.365 Water and Jug Problem
 * 思路:
 *      z 如果是 x 和 y 的最大公约数的倍数，那么就一定能够被倒出来
 *
 *
 *
 *
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 *
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 *
 * Operations allowed:
 *
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 *
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 *
 * Input: x = 2, y = 6, z = 5
 * Output: False
 *
 *
 *
 *
 */
public class WaterandJugProblem {
    private int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }


    /*
        7  3 6 7 2 5 7 1 4 7
        3  3 3 2 3 3 1 3 3 3
    */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (z == 0 || y == z || x == z || x + y == z) return true;
        if (x == 0 || y == 0) return false;
        return z % gcd(x, y) == 0;
    }
}
