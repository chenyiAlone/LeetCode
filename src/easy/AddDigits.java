package easy;
/**
 * 
 * ClassName: AddDigits
 * @author chenyiAlone  
 * Create Time: 2019/03/06 21:24:19
 * Description: No.258
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

    Example:
    
    Input: 38
    Output: 2 
    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
                 Since 2 has only one digit, return it.
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num > 9) {
            num = helper(num);
        }
        return num;
    }
     
    public static int helper(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int num =38;
        System.out.println(new AddDigits().addDigits(num));
    }
}
