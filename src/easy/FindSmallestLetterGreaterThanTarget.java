package easy;

import java.util.*;

/**
 * ClassName: FindSmallestLetterGreaterThanTarget.java
 * Author: chenyiAlone
 * Create Time: 2019/11/1 22:32
 * Description: No.744 Find Smallest Letter Greater Than Target
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        char ret = target;
        for (char c : letters) {
            if (c > target) {
                if (ret <= target) ret = c;
                else ret = (char)Math.min(ret, c);
            } else if (c < target) {
                if (ret > target) continue;
                if (ret == target) ret = c;
                else ret = (char)Math.min(ret, c);
            }
        }
        return ret;
    }

}