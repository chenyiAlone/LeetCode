package medium;

import java.util.Arrays;
/**
 * ClassName: SortCharactersByFrequency.java
 * Author: chenyiAlone
 * Create Time: 2019/9/2 22:27
 * Description: No.451 Sort Characters By Frequency
 * 思路:
 *      1. 统计个位的个数，并排序
 *      2. 按照顺序 append 到结果上
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 */
public class SortCharactersByFrequency {
    class Pair implements Comparable<Pair>{
        char c;
        int cnt;
        public Pair() {}
        private Pair(char c) {
            this.c = c;
        }
    
        @Override
        public int compareTo(Pair o) {
            return -(cnt - o.cnt);
        }
    
    }

    public String frequencySort(String s) {
        Pair[] ps = new Pair[256];
        for (char i = 0; i < 256; i++) {
            ps[i] = new Pair(i);
        }
        StringBuilder ret = new StringBuilder();
        for (char c : s.toCharArray()) {
            ps[c].cnt++;
        }
        Arrays.sort(ps);
        for (int i = 0; i < 256; i++) {
            if (ps[i].cnt == 0)
                break;
            while (ps[i].cnt-- > 0) ret.append(ps[i].c);
        }
        return ret.toString();
    }
}