package hard;
/**
 * ClassName: RemoveDuplicateLetters.java
 * Author: chenyiAlone
 * Create Time: 2019/5/28 15:14
 * Description: No.316
 * 思路:
 *      1. 统计不同的元素个数 total，lboard 作为作为在 s 中的指针
 *      2. 重复 total 次枚举 a - z ，
 *          1).这个字母在 res 中了，continue
 *          2). 这个字母在 res 中没有出现过
 *              && 在 s 的 lboard - len 之间出现了(记作为 index)
 *              && res 中的不同字母数量加上剩余的 s 中的数目刚好等于 total
 *                  就将这个字母加到 res 中并且更新 lboard = index + 1
 *      3. 如果 index == -1 continue;`
 *
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear
 * once and only once. You must make sure your result is the smallest in lexicographical order among all possible
 * results.
 *
 * Example 1:
 *
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: "cbacdcbc"
 * Output: "acdb"
 *
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int total = 0;
        int len = s.length();
        boolean[] appeared = new boolean[26];
        for (int i = 0; i < len; i++) {
            int c = s.charAt(i) - 'a';
            if (!appeared[c]) {
                appeared[c] = true;
                total++;
            }
        }
        // System.out.println(total);
         StringBuilder res = new StringBuilder();
        int l = 0;
        for (int t = 0; t < total; t++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (res.indexOf(c + "") != -1)
                    continue;
                int index = -1;
                for (int i = l; i < len; i++) {
                    if (s.charAt(i) == c) {
                        index = i;
                        break;
                    }
                    // System.out.println(index + " + " + c);
                }
                if (index == -1)
                    continue;
                boolean[] apr = new boolean[26];
                int tempSum = 0;

                for (int i = index; i < len; i++) {
                    if (!apr[s.charAt(i) - 'a']) {
                        apr[s.charAt(i) - 'a'] = true;
                        tempSum ++;
                    }
                }
                for (int i = 0; i < res.length(); i++) {
                    if (!apr[res.charAt(i) - 'a']) {
                        apr[res.charAt(i) - 'a'] = true;
                        tempSum ++;
                    }
                }
                if (tempSum == total) {
                    res.append(c);
                    l = index;
                    break;
                }
                //             for (int j = 0; i < len; i++) {
                //                 int c = s.charAt(i) - 'a';
                //             }
            }
            // System.out.println();
        }
        return res.toString();
    }
}