package easy;
/**
 * 
 * ClassName: CountandSay
 * @author chenyiAlone  
 * Create Time: 2019/03/26 17:01:31
 * Description: No.38
 * 思路:
 *     1. 从 n == 1 开始，last 记录每次报数的结果
 *     2. 更新 count 统计的 last 相同连续字符数量以及当前字符到 tmp
 *     3. 将 last 更新为 tmp
 * 
 */
public class CountandSay {
    public String countAndSay(int n) {
        String last = "1";
        for (int i = 0; i < n; i++) {
            String tmp = "";
            int j = 0;
            while (j < last.length()) {
                int count = 1;
                char c = last.charAt(j);
                while (j + 1 < last.length() && last.charAt(j + 1) == c) {
                    count++;
                    j++;
                }
                tmp += count;
                tmp += String.valueOf(c);
                j++;
            }
            last = tmp;
        }
        return last;
    }
}
