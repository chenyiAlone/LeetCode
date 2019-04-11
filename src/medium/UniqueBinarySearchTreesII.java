package medium;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;
/**
 * 
 * ClassName: UniqueBinarySearchTreesII
 * @author chenyiAlone  
 * Create Time: 2019/04/11 17:52:50
 * Description: No.95
 * 思路:
 *     1. l r 作为边界
 *     2. 总的结点数为 n, 那么 i 为根的 Binary Search 就是以 [1 ... i - 1]为左子树
 *        以及以 [i + 1 ... r] 的所有子树的组合
 *     3. 边界条件 
 *          a. l > r   => return [[null]] 
 *          b. l == r  => return [[l]]
 * 
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
    
    Example:
    
    Input: 3
    Output:
    [
      [1,null,3,2],
      [3,2,null,1],
      [3,1,null,null,2],
      [2,1,3],
      [1,null,2,null,3]
    ]
    Explanation:
    The above output corresponds to the 5 unique BST's shown below:
    
       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return dfs(1, n); 
    }
    List<TreeNode> dfs(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l == r) {
            res.add(new TreeNode(l));
            return res;
        }
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> lts = dfs(l, i - 1);
            List<TreeNode> rts = dfs(i + 1, r);
            for (TreeNode lt : lts) {
                for (TreeNode rt : rts) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = lt;
                    tmp.right = rt;
                    res.add(tmp);
                }
            }
        }
        return res; 
    }
}