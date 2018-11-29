package medium;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * Example 1:
 *      Input: s = "PAYPALISHIRING", numRows = 3
 *      Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *      Input: s = "PAYPALISHIRING", numRows = 4
 *      Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * @author chenyiAlone
 *
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int n = numRows *2 -2;  // 将Explanation中所示的图,从第一个P元素向下，然后向上折回到I之前的L为一组
        if (n == 0) return s;
        char[] ans = new char[s.length()];
        for (int i = 0, count = 0; i < numRows; i++) {
            for (int j = i, k = n - 2 * (j % n); j < s.length(); ) {
                if (k != 0) {
                    ans[count++] = s.charAt(j);
                    j += k;
                    k = n - k;
                } else {
                    j += k;
                    k = n - k;
                }
            }
        }
        return new String(ans);
    }
}
