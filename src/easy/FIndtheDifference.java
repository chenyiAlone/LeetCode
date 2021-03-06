package easy;
/**
 * 
 * ClassName: FIndtheDifference
 * @author chenyiAlone  
 * Create Time: 2019/02/21 19:51:13
 * Description: No.389
 * Given two strings s and t which consist of only lowercase letters.
    
    String t is generated by random shuffling string s and then add one more letter at a random position.
    
    Find the letter that was added in t.
    
    Example:
    
    Input:
    s = "abcd"
    t = "abcde"
    
    Output:
    e
    
    Explanation:
    'e' is the letter that was added.
 */
public class FIndtheDifference {
    public char findTheDifference(String s, String t) {
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++; 
        }
        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i)] == 0) return t.charAt(i);
            else map[t.charAt(i)]--;
        }
        return '0';
    }
}