package easy;
/**
 * ClassName: CanPlaceFlowers.java
 * Author: chenyiAlone
 * Create Time: 2019/11/5 21:28
 * Description: No.605 Can Place Flowers
 *
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 *
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 *
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int total = 0;
        for (int i = 0, cnt = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                cnt++;
                if (i == flowerbed.length - 1) {
                    if (i - cnt == -1) total += Math.ceil(cnt / 2.0);
                    else total += cnt / 2;
                }
            } else {
                if (cnt != 0) {
                    // 1 0 1 0 1 0
                    if (i - cnt == 0) {
                        total += cnt / 2;
                        // 1 2 3 4 5 6
                        // 0 1 1 2
                    } else {
                        total += (cnt - 1) / 2;
                        // 1 2 3 4 5 6 
                        // 0 0 1 1 2 2
                    }
                }
                cnt = 0;
            }

        }
        return n <= total;
    }
}