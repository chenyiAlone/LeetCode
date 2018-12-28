package easy;
/**
 * 
 * ClassName: SqrtX
 * @author chenyiAlone  
 * Create Time: 2018/12/28 21:13:26
 * Description: No.69
 * Implement int sqrt(int x).

    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
    
    Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
    
    Example 1:
    
    Input: 4
    Output: 2
    Example 2:
    
    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since 
                 the decimal part is truncated, 2 is returned.
 */
public class SqrtX {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
    public static void main(String[] args) {
        int x = 5;
        System.out.println(new SqrtX().mySqrt(x));
    }

}
