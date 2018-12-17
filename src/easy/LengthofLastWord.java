package easy;
/**
 * 
 * ClassName: LengthofLastWord
 * @author chenyiAlone  
 * Create Time: 2018/12/17 21:15:06
 * Description: No.58
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int ans = 0, temp = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return ans;
            } else {
                temp++;
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String s = "a";
        System.out.println(new LengthofLastWord().lengthOfLastWord(s));
    }
}
