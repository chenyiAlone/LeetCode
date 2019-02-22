package easy;
/**
 * 
 * ClassName: RansomNote
 * @author chenyiAlone  
 * Create Time: 2019/02/22 18:46:08
 * Description: No.383
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
    
    Each letter in the magazine string can only be used once in your ransom note.
    
    Note:
    You may assume that both strings contain only lowercase letters.
    
    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map[ransomNote.charAt(i)]-- == 0) return false;
        }
        return true;
    }
}