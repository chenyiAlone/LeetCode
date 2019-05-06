package easy;

import java.util.Arrays;
/**
 * ClassName: IsomorphicStrings.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/6 16:55
 * Description: No.205
 * 思路:
 *      1. int[256] map 保存 s 到 t 的映射
 *      2. boolean[] appear 用于记录被映射的按键是否重复
 *           s: "ab" => a->a  √
 *           t: "aa"    a->b  × // repeat mapping
 *      3. 原本使用了 str.charAt(i) 运行时间过长，改用了 str.toCharArray()，时间正常，
 *          重新测试比较了两种情况，发现
 *
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 *
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (len == 0)
            return true;
        int[] map = new int[256];
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        boolean[] appear = new boolean[256];
        Arrays.fill(map, -1);
        for (int i = 0; i < len; i++) {
            if (map[str1[i]] == -1) {
                if (appear[str2[i]])
                    return false;
                appear[str2[i]] = true;
                map[str1[i]] = str2[i];
            } else {
                if (map[str1[i]] != str2[i])
                    return false;
            }
        }
        return true;
    }
}
