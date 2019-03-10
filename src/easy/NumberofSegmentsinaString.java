package easy;
/**
 * 
 * ClassName: NumberofSegmentsinaString
 * @author chenyiAlone  
 * Create Time: 2019/03/10 18:42:41
 * Description: No.434
 * 总结:
 *     1. 单词数目增加的条件: 单词的长度 len == 0 && c != ' '
 *     2. 遇到空格时将 len 置零
 *     
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

    Please note that the string does not contain any non-printable characters.
    
    Example:
    
    Input: "Hello, my name is John"
    Output: 5
 */
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        int count = 0; 
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') len = 0;
            if (c != ' ' && len == 0) {
                count++;
                len = 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "Hello, my name is John";
        System.out.println(new NumberofSegmentsinaString().countSegments(s));
    }
}