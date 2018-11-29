package easy;
/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 *      Input: ["flower","flow","flight"]
 *      Output: "fl"
 *      
 * Example 2:
 *      Input: ["dog","racecar","car"]
 *      Output: ""
 * Explanation: There is no common prefix among the input strings
 * 
 * Note:
 *      All given inputs are in lowercase letters a-z.
 * @author chenyiAlone
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer langestCommonPrefix = new StringBuffer("");
        boolean flag = true;
        int id = 0;
        try {
            while (true) {
                for (int i = 1; i < strs.length; i ++) {
                    if (strs[i-1].charAt(id) != strs[i].charAt(id)) { 
                        flag = false; 
                        break;
                    }
                }
                if (flag) langestCommonPrefix.append(strs[0].charAt(id++));
                else return langestCommonPrefix.toString();
            }
        } catch (Exception e) {
            return langestCommonPrefix.toString();
        }
    }
    
    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "flow";
        strs[1] = "flower";
        strs[2] = "fli";
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}

/*output:
fl

*/
