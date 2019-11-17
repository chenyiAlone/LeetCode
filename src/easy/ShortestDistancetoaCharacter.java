package easy;

import java.uitl.Math;
/**
 * ClassName: ShortestDistancetoaCharacter.java
 * Author: chenyiAlone
 * Create Time: 2019/11/ 
 * Description: No.821 Shortest Distance to a Character
 */
public class ShortestDistancetoaCharacter {

    public int[] shortestToChar(String S, char C) {
        int[] prev = new int[S.length()], next = new int[S.length()];
        int last = -1, first = -1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) last = i;
            prev[i] = last == -1 ? Integer.MAX_VALUE : (i - last);
            int j = S.length() - 1 - i;
            if (S.charAt(j) == C) first = j;
            next[j] = first == -1 ? Integer.MAX_VALUE : (first - j);
        }
        int[] ret = new int[S.length()];
        for (int i = 0; i < S.length(); i++) ret[i] = Math.min(prev[i], next[i]);
        return ret;
    }
    
}
