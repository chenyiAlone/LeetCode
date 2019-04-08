package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * ClassName: Combinations
 * @author chenyiAlone  
 * Create Time: 2019/04/07 22:55:30
 * Description: No.77
 * 思路:
 *   1. DFS + BackTracking
 *   2. 拼凑
 *      a. 将 tmp[k] 置为 前 k 个数，从后向前遍历数组，如果当前元素等于当前位的最大值 i--
 *      b. tmp[i]++
 *      c. i + 1 -> k - 1 的元素置为从 i 起的自然数升序排序
 *   拼凑的重点就是不是最后一个数开始增加的时候，容易忽略掉最后一位更小值的情况，eg: 1, 4-> 2, 4 缺漏掉了 2, 3
 *   
 *   
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    
    Example:
    
    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
 */
public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        new Combinations().combine2(n, k);
    }
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k > n)
            return res;
        Integer[] tmp = new Integer[k];
        for (int i = 1; i <= k; i++) {
            tmp[i - 1] = i;
        }
        res.add(new ArrayList<Integer>(Arrays.asList(tmp)));        
        while (true) {
            int i = k - 1;
            while (i >= 0 && tmp[i] + (k - i - 1) >= n) i--;
            if (i < 0) break;
            tmp[i]++;
            for (int j = i + 1; j < k; j++) {
                tmp[j] = tmp[i] + (j - i);
            }
            res.add(new ArrayList<Integer>(Arrays.asList(tmp)));    
            
        }
        return res;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (n == 0 || n < k)
            return res;
        dfs(1, n, k, res, tmp);
        return res;
    }
    
    public void dfs(int p, int n, int k, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList(tmp));
            return;
        }
            
        for (int i = p; i <= n; i++) {
            tmp.add(i);
            dfs(i + 1, n, k, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}