package easy;
/**
 * 
 * ClassName: VaildAnagram
 * @author chenyiAlone  
 * Create Time: 2019/03/09 19:06:43
 * Description: No.242
 *
 * --------------- update -----------------
 * update time: 2019/5/15
 *
 * 思路:
 *      更新原来的算法，只需要在每次 count -= 1 之后判断这个值是不是小于 0 了即可，不需要重新遍历一遍数组
 *
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 *
 */
public class VaildAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : t.toCharArray()) {
            count[c]--;
            if (count[c] < 0)
                return false;
        }
        return true;
    }

    public boolean isAnagramOld(String s, String t) {
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        for (char c : t.toCharArray()) {
            if (map[c] > 0) {
                map[c]--;
            } else {
                return false;
            }
        }
        for (int i : map) {
            if (i != 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        System.out.println(new VaildAnagram().isAnagram(s, t));
    }
}