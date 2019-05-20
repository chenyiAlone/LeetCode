package medium;
/**
 * ClassName: BullsandCows.java
 * Author: chenyiAlone
 * Create Time: 2019/5/20 15:22
 * Description: No.299
 * 思路:
 *      1. int[10] 保存元素中的个数
 *      2. 遍历两次，分别对应猜对和猜错两种情况计数 cntA + cntB
 *
 *
 *
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and
 * ask your friend to guess what the number is. Each time your friend makes a guess, you provide a
 * hint that indicates how many digits in said guess match your secret number exactly in both digit
 * and position (called "bulls") and how many digits match the secret number but locate in the wrong
 * position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to
 * indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their
 * lengths are always equal.
 */
public class BullsandCows {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        if (len == 0)
            return "0A0B";
        int cntA = 0, cntB = 0;
        int[] count = new int[10];
        for (int i = 0; i < len; i++) {
            count[secret.charAt(i) - '0'] ++;
        }
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i) && count[secret.charAt(i) - '0'] != 0) {
                count[secret.charAt(i) - '0'] -= 1;
                cntA++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) != guess.charAt(i) && count[guess.charAt(i) - '0'] != 0) {
                count[guess.charAt(i) - '0'] -= 1;
                cntB++;
            }
        }


        return cntA + "A" + cntB + "B";
    }
}
