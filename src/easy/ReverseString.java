package easy;
/**
 * 
 * ClassName: ReverseString
 * @author chenyiAlone  
 * Create Time: 2019/02/26 21:45:04
 * Description: No.344
 * Write a function that reverses a string. The input string is given as an array of characters char[].

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    
    You may assume all the characters consist of printable ascii characters.
    
     
    
    Example 1:
    
    Input: ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
    Example 2:
    
    Input: ["H","a","n","n","a","h"]
 */
public class ReverseString {
    public void reverseString(char[] s) {
        char tmp;
        int lo = 0, hi = s.length - 1;
        while (lo < hi) {
            tmp = s[lo];
            s[lo++] = s[hi];
            s[hi--] = tmp;
        }
    }
}