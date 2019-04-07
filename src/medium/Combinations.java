package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: Combinations
 * @author chenyiAlone  
 * Create Time: 2019/04/07 22:55:30
 * Description: No.77
 * 思路:
 *   DFS + BackTracking
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