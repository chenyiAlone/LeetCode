package easy;
/**
 * 
 * ClassName: CountPrimes
 * @author chenyiAlone  
 * Create Time: 2019/02/20 19:48:29
 * Description: No.204
 * 总结:
 *     1. 
 * 
 * Count the number of prime numbers less than a non-negative number, n.
    
    Example:
    Input: 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        int count = 0;
        for(int d = 2; d < n; d++){

            if (d <= 3 && d > 1) { count++; continue; }
            if (d % 2 == 0 || d % 3 == 0) { continue; }
            int nonPrime = 0;
            for (int i = 5; i * i <= d; i += 6) {
                if (d % i == 0 || d % (i + 2) == 0) { nonPrime = 1; break; }
            }
            if(nonPrime == 0) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
    }
}
