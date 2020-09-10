package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyiAlone
 * @date 2020/09/10 09:32
 *
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *  
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *  
 *
 * Note:  1 <= S.length <= 1000
 *
 */
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ret = new ArrayList<>(S.length() / 2);
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(startIndex)) {
                if (endIndex - startIndex + 1 >= 3) {
                    ret.add(Arrays.asList(startIndex, endIndex));
                }
                startIndex = i;
            }
            endIndex = i;
        }
        if (startIndex != endIndex && endIndex - startIndex + 1 >= 3) {
            ret.add(Arrays.asList(startIndex, endIndex));
        }
        return ret;
    }

}
