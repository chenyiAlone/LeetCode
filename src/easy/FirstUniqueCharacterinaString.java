package easy;
/**
 * 
 * ClassName: FirstUniqueCharacterinaString
 * @author chenyiAlone  
 * Create Time: 2019/01/02 08:26:56
 * Description: No.387
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:
    
    s = "leetcode"
    return 0.
    
    s = "loveleetcode",
    return 2.
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        if (s == "") return -1; 
        int[][] index = new int[2][60];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
            index[0][c - 'A'] = i;
            index[1][c - 'A']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (index[1][s.charAt(i) - 'A'] == 1) return index[0][s.charAt(i) - 'A'];
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("".length());
        String s = "z";
        System.out.println(new FirstUniqueCharacterinaString().firstUniqChar(s));
    }
}
