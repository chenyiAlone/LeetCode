package easy;
/**
 * 
 * ClassName: PlusOne
 * @author chenyiAlone  
 * Create Time: 2018/12/19 20:50:16
 * Description: No.66  
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int cy = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if ((cy = digits[i] /10) > 0) {
                digits[i] = digits[i] % 10;
                digits[i - 1] += cy;
            }
        }
        if ((cy = digits[0] / 10) > 0) {    // 判断最高位进位
            digits[0] = digits[0] % 10;
            int[] ans = new int[digits.length + 1];
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            ans[0] = cy;
            return ans;
        } else {
            digits[0] += cy;
            return digits;    
        }
    }

}
