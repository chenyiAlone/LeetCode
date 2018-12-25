package medium;
/**
 * 
 * ClassName: PowXN
 * @author chenyiAlone  
 * Create Time: 2018/12/25 21:55:37
 * Description: No.50
 * Implement pow(x, n), which calculates x raised to the power n (xn).

    Example 1:
    
    Input: 2.00000, 10
    Output: 1024.00000
    Example 2:
    
    Input: 2.10000, 3
    Output: 9.26100
    Example 3:
    
    Input: 2.00000, -2
    Output: 0.25000
    Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        boolean flag = n < 0;
        long oldN = n;
        oldN = flag ? -oldN : oldN;
        double ans = x;
        long count = 1;
        System.out.println("oldN = " + oldN);
        while (count < oldN) {
            long tc = 1;
            double temp = x;
            while (tc * 2 + count < oldN) {
                temp *= temp;
                tc = 2 * tc;
                if (ans == 0) {
                    count = oldN;
                    break;
                }
            }
            count += tc;
            ans *= temp;
            
        }
        return flag ? 1 / ans : ans;
    }
    
    public static void main(String[] args) {
        double x = 2.0;
        int n = -2147483648;
//        System.out.println(Long.MAX_VALUE);
        System.out.println(new PowXN().myPow(x, n));
    }
}
