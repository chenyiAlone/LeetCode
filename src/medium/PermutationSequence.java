package medium;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * ClassName: PermutationSequence
 * @author chenyiAlone  
 * Create Time: 2019/03/28 16:33:05
 * Description: No.60
 * 思路:
 *     1. n 个数有 n! 的全排列，那么 n - 1 个数就有 (n - 1)! 个全排列
 *     2. (k -1) / (n - 1)! => n 的全排列的 第 k 个全排列的第一个数字的 index
 *     3. k % (n - 1)! => n 个数的全排列的第 k 个序列的对应的 个排列的 'k' 值(即 k % (n - 1)!)
 * 做法: 
 *     1. List<Integer> num 记录 n 个数，方便后面的按下标取值
 *     2. fact[i] 用来记录 i 个数全排列的总数， 刚好对应后面的 n 个数的 fact[n - 1] 也就 n - 1 个数的全排列总数
 *     3. k-- 用于使下标对应，求 num 的下标 index = k / fact[i - 1]; 更新 k = k % fact[n - 1];
 *     
 * eg:
 *     n = 2, 
 *     fact[2] = {1, 1};    
 * 
 *     
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
    
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    Given n and k, return the kth permutation sequence.
    
    Note:
    
    Given n will be between 1 and 9 inclusive.
    Given k will be between 1 and n! inclusive.
    Example 1:
    
    Input: n = 3, k = 3
    Output: "213"
    Example 2:
    
    Input: n = 4, k = 9
    Output: "2314"
 *     
 *     
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        //   3      3
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) 
            num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) 
            fact[i] = i * fact[i - 1];
        // fact: {1, 1, 2}
        k = k - 1;
        // k = 2
        StringBuilder sb = new StringBuilder();
        
        for (int i = n; i > 0; i--){
            // 1. ind = 2 / 2 = 1  k = 2 % 2 = 0  str = "2"    num = {1, 2, 3}; => {1, 3};
            // 2. ind = 0 / 1 = 0  k = 0 % 1 = 0  str = "21"   num = {1, 3};    => {3};
            // 3. ind = 0 / 1 = 0  k = 0 % 1 = 0  str = "213"  num = {3};       => {};
            int ind = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
}
