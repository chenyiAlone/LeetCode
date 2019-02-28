package easy;
/**
 * 
 * ClassName: PowerofTwo
 * @author chenyiAlone  
 * Create Time: 2019/02/28 20:38:56
 * Description: No.231
 * Given an integer, write a function to determine if it is a power of two.
    
    Example 1:
    
    Input: 1
    Output: true 
    Explanation: 20 = 1
    Example 2:
    
    Input: 16
    Output: true
    Explanation: 24 = 16
    Example 3:
    
    Input: 218
    Output: false
 */
public class PowerofTwo {
    // fast
    public boolean isPowerOfTwo(int n) {
        if (n <=0 ) return false;
        return (n & (n - 1)) == 0;
    }
    // slow
    public boolean isPowerOfTwoSlow(int n) {
        long i = 1;
        while (i < n) {
            i <<= 1;
        }
        if (i == n) return true;
        else return false;
    }
    public static void main(String[] args) {
        int n = 1073741825;
        System.out.println(new PowerofTwo().isPowerOfTwo(n));
    }
}