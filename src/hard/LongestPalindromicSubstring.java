package hard;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 *      Input: "babad"
 *      Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 *      Input: "cbbd"
 *      Output: "bb"
 *      
 * @author chenyiAlone
 *
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int size = 0;
        int start = -1;
        int lo, hi;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                lo = i;
                hi = i + j;
//                System.out.println("lo = " + lo + "  hi = " + hi);
                while (lo <= hi) {
                    if (s.charAt(lo) != s.charAt(hi)) {     // 两侧向中间依次进行比较
                        flag = false;
                        break;
                    }
                    lo++;
                    hi--;
                }
//                System.out.println("sub = " + s.substring(i, i + j + 1) + " is " + flag);
                if (flag && size < j + 1) {
                    size = j + 1;
                    start = i;
                }
                flag = true;
            }
        }
        if (start != -1) return s.substring(start, start + size); 
        return "";
    }
   
    /**
     * 第一个使用了StringBuffer来判断是否是回文的版本,
     * 但是对于长的字符串s操作超时,失败
     * @param s
     * @return
     */
    public String longestPalindromeA(String s) {
        int size = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j + i <= s.length(); j++) {
                String sub = s.substring(i, i + j);
                boolean flag = sub.equals(new StringBuffer(sub).reverse().toString()) && j > size;
                if (flag) {
                    size = j;
                    start = i;
                }
//                System.out.println(sub + "  is flag = " + flag);
            }
        }
//        System.out.println("start = " + start + "  size = " + size);
        if (start != -1) return s.substring(start, start + size); 
        return "";
    }
    public static boolean isPalind(String s, int start, int size) {
        String sub = s.substring(start, start + size);
        if (sub.equals("")) return false;
//        System.out.println(sub + " is " + sub.equals(new StringBuffer(sub).reverse().toString()));
        return sub.equals(new StringBuffer(sub).reverse().toString());
    }
    
    
    public static void main(String[] args) {
        String s = "bab";
        LongestPalindromicSubstring ls = new LongestPalindromicSubstring();
        System.out.println("ans = " + ls.longestPalindrome(s));
//        System.out.println("s".charAt(0));
//        System.out.println("abcd".substring(0, 0 + 3));
    }
}
