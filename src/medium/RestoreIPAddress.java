package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: RestoreIPAddress
 * @author chenyiAlone  
 * Create Time: 2019/04/11 17:09:23
 * Description: No.93
 * 思路:
 *     1. DFS 
 *     2. string-> integer 
 *     3. 忽略以 0 开头的数值 
 *            if (s.charAt(index) == '0' && i != index) // i = index && index == 0 可以通过，也是就这个区段为 0
 *                continue;
 *     4. "123".substring(0, 1) => "1"
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    Example:
    
    Input: "25525511135"
    Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        dfs(0, s, "", res, 0);
        return res;
    }
    private void dfs(int index, String s, String tmp, List<String> res, int wn) {
        if (index == s.length() || wn >= 4) {
            if (index == s.length() && wn == 4) {
                res.add(tmp.substring(0, tmp.length() - 1));
            }
            return;
        }
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            if (s.charAt(index) == '0' && i != index)
                continue;
            String str = s.substring(index, i + 1);
            int num = Integer.valueOf(str);
            if (num <= 255)
                dfs(i + 1, s, tmp + str + ".", res, wn + 1);
        }
    }
}
