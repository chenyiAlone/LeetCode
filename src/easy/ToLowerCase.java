package easy;

import java.util.*;

/**
 * ClassName: ToLowerCase.java
 * Author: chenyiAlone
 * Create Time: 2019/10/28 22:05
 * Description: No.709 To Lower Case
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder ret = new StringBuilder();
        for (char c : str.toCharArray())
            ret.append(('A' <= c && c <= 'Z') ? (char)(c + 32) : c);
        return ret.toString();
    }

}