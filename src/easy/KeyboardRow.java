package easy;

import java.util.*;
/**
 * ClassName: KeyboardRow.java
 * Author: chenyiAlone
 * Create Time: 2019/9/21 21:50
 * Description: No.500 Keyboard Row
 * 思路:
 *
 *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *  
 * Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *  
 *
 * Note:
 *
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 */
public class KeyboardRow {

    private int[] map = {2, 3, 3, 2, 1, 2, 2,
            2, 1, 2, 2, 2, 3, 3,
            1, 1, 1, 1, 2, 1,
            1, 3, 1, 3, 1, 3};
    private int id(char c) {
        if ('a' <= c && c <= 'z') return c - 'a';
        return c - 'A';
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String w : words) {
            boolean can = true;
            for (int i = 0; i < w.length() - 1; i++) {
                if (map[id(w.charAt(i))] != map[id(w.charAt(i + 1))]) {
                    can = false;
                    break;
                }
            }
            if (can) list.add(w);
        }
        return list.toArray(new String[]{});
    }
}
