package easy;
/**
 * 
 * ClassName: ValidPalindrome
 * @author chenyiAlone  
 * Create Time: 2019/03/11 20:04:11
 * Description: No.125
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Note: For the purpose of this problem, we define empty string as valid palindrome.
    
    Example 1:
    
    Input: "A man, a plan, a canal: Panama"
    Output: true
    Example 2:
    
    Input: "race a car"
    Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String[] strs = s.split("[^a-zA-Z]");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        String newStr = sb.toString().toLowerCase();
        System.out.println(newStr);
        int lo = 0, hi = newStr.length() - 1;
        while (lo < hi) {
            if (newStr.charAt(lo) != newStr.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }
    public static void main(String[] args) {
        
        String s2 = "A man, a plan, a canal: Panama";
        String s = "op";
        System.out.println(new ValidPalindrome().isPalindrome(s));
//        String[] strs = s.split("[^a-zA-Z]");
//        StringBuilder sb = new StringBuilder();
//        for (String str : strs) {
//            sb.append(str);
//        }
//        String newStr = sb.toString().toLowerCase();
//        System.out.println(newStr);
//        int lo = 0, hi = newStr.length() - 1;
//        while (lo < hi) {
//            if (newStr.charAt(lo) != newStr.charAt(hi)) {
//                System.out.println("y");
//                break;
//            }
//            lo++;
//            hi--;
//        }
//        System.out.println("n");
    }
}