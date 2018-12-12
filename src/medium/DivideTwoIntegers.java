package medium;
/**
 * 
 * ClassName: DivideTwoIntegers
 * @author chenyiAlone  
 * Create Time: 2018/12/12 08:39:24
 * Description: No.29
 */
public class DivideTwoIntegers {
    
    public int divide(int dividend, int divisor) {
        long ndividend = dividend, ndivisor = divisor;
        boolean isNegative  = false;
        if (ndividend < 0) {
            if (ndivisor < 0) {
                ndivisor = -ndivisor;
            } else {
                isNegative = true;
            }
            ndividend = -ndividend;
        } else {
            if (ndivisor < 0) {
                isNegative = true;
                ndivisor = -ndivisor;
            }
        }
        int count = 0;
        while (ndividend >= ndivisor) {
            if (count == Integer.MAX_VALUE && !isNegative) return isNegative ? -count : count;
            long t = ndivisor;
            int i = 1;
            while (ndividend >= t) {
//                System.out.println("count = " + count + "  +  i = " + i);
                ndividend -= t;
                count += i;
                i <<= 1;
                t <<= 1;
            }
        }
        return isNegative ? -count : count;
    }
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(new DivideTwoIntegers().divide(2147483647, 1));
//        System.out.println(-0);
        
    }
}
