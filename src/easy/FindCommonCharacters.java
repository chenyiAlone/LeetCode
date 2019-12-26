package easy;

import java.util.*;

/**
 * ClassName: FindCommonCharacters.java
 * Author: chenyiAlone
 * Create Time: 2019/12/26
 * Description: No.1002 Find Common Characters
 */
public class FindCommonCharacters {


    public List<String> commonChars(String[] A) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        for (String s : A) {
            int[] temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++)
                cnt[i] = Math.min(cnt[i], temp[i]);
        }
        List<String> ret = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            while (cnt[i]-- > 0)
                ret.add("" + (char)('a' + i));
        }
        return ret;
    }
    
}