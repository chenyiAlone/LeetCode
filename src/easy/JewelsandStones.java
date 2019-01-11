package easy;
/**
 * 
 * ClassName: JewelsandStones
 * @author chenyiAlone  
 * Create Time: 2019/01/11 21:32:09
 * Description: No.771
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

    The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
    
    Example 1:
    
    Input: J = "aA", S = "aAAbbbb"
    Output: 3
    Example 2:
    
    Input: J = "z", S = "ZZ"
    Output: 0
    Note:
    
    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.
 */
public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        boolean[] flags = new boolean[128];
        for (char c : J.toCharArray()) {
            flags[c] = true;
        }
        for (char c : S.toCharArray()) {
            if (flags[c]) ans++;
        }
        return ans;
    }
}
