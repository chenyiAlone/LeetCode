package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ClassName: RepeatedDNASequences.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/5 14:15
 * Description: No.187
 * 思路:
 *      1. 00, 01, 10, 11 记录四种状态，共计 10 位，int 即可表示
 *      2. int[Math.pow(2, 20)] 用于所有的情况的对应下标
 *      3. if (appeared[cur]++ == 1) 用于排除重复
 *
 *
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0); map.put('C',1); map.put('G', 2); map.put('T', 3);

        int[] appeared = new int[(int)Math.pow(2, 20)];
        int len = s.length();
        for (int i = 0; i + 9 < len; i++) {
            int cur = 0;
            for (int j = 0; j < 10; j++) {
                cur = cur << 2 | map.get(s.charAt(i + j));
            }
            if (appeared[cur]++ == 1)
                res.add(s.substring(i, i + 10));
        }
        return res;
    }
}
