package easy;
/**
 * ClassName: GuessNumberHigherorLower.java
 * Author: chenyiAlone
 * Create Time: 2019/7/20 23:59
 * Description: No.374 Guess Number Higher or Lower
 * 思路:
 *
 *      1. Binary Search
 *      2. l + r 爆 int
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 *
 */
public class GuessNumberHigherorLower {
    static class GuessGame {
        int guess(int num) {
            return 0;
        }
    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l = 1, r = n;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                switch (guess(mid)) {
                    case 1:
                        l = mid + 1;
                        break;
                    case -1:
                        r = mid - 1;
                        break;
                    case 0:
                        return mid;
                }
            }
            return -1;
        }
    }
}