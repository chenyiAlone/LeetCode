package hard;

/**
 * ClassName: MinimumWindowSubstring.java
 * Author: chenyiAlone
 * Create Time: 2019/11/20 22:34 
 * Description: No.76 Minimum Window Substring
 */
public class MinimumWindowSubstring {

    private boolean can(int[] cnt, int[] temp) {
        for (int i = 0; i < cnt.length; i++) if (cnt[i] > temp[i]) return false;
        return true;
    }
    
    public String minWindow(String s, String t) {
        int[] cnt = new int[256];
        int[] temp = new int[256];
        for (char c : t.toCharArray()) cnt[c]++;
        int start = -1, retLen = Integer.MAX_VALUE;
        int len = s.length(), l = 0, r = -1;
        for ( ; l < len && r < len; ) {
            while (can(cnt, temp) && l < len) {
                if (start == -1 || r - l + 1 < retLen) {
                    start = l;
                    retLen = r - l + 1; 
                }                
                temp[s.charAt(l)]--;               
                l++;
            }
            while (!can(cnt, temp) && r < len) {
                r++;
                if (r < len) temp[s.charAt(r)]++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + retLen);
    }
    
}