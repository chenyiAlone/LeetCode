package easy;
/**
 * 
 * ClassName: VaildAnagram
 * @author chenyiAlone  
 * Create Time: 2019/03/09 19:06:43
 * Description: No.242
 * Given two strings s and t , write a function to determine if t is an anagram of s.
    
    Example 1:
    
    Input: s = "anagram", t = "nagaram"
    Output: true
    Example 2:
    
    Input: s = "rat", t = "car"
    Output: false
    Note:
    You may assume the string contains only lowercase alphabets.
 */
public class VaildAnagram {
    public boolean isAnagram(String s, String t) {
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