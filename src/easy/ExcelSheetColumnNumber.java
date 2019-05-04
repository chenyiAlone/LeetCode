package easy;
/**
 * ClassName: ExcelSheetColumnNumber.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/4 19:28
 * Description: No.172
 *
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int total = 0;
        for (char c : s.toCharArray()) {
            total *= 26;
            total += c - 'A' + 1;
        }
        return total;
    }
}
