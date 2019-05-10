package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName: CombinationSumIII.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/10 16:28
 * Description: No.216
 * 思路:
 *      DFS
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class CombinationSumIII {
    private List<List<Integer>> res = null;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        if (n < k)
            return res;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            tmp.add(i);
            dfs(k - 1, i, n - i, tmp);
            tmp.remove(tmp.size() - 1);
        }

        return res;
    }


    private void dfs(int k, int index, int sum, List<Integer> tmp) {
        if (k == 0){
            if (sum == 0) {
                res.add(new ArrayList<>(tmp));
            }
        } else {
            for (int i = index + 1; i <= 9; i++) {
                tmp.add(i);
                dfs(k - 1, i, sum - i, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
