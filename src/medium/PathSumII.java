package medium;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * 
 * ClassName: PathSumII
 * @author chenyiAlone  
 * Create Time: 2019/04/15 17:29:41
 * Description: No.113
 * 思路:
 *   DFS + BackTrackign
 * 
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    
    Note: A leaf is a node with no children.
    
    Example:
    
    Given the below binary tree and sum = 22,
    
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1
    Return:
    
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(TreeNode root, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (root != null && root.left == null && root.right == null && root.val == target) {
            tmp.add(root.val);
            res.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        if (root == null)
            return;
        tmp.add(root.val);
        dfs(root.left, target - root.val, new ArrayList<Integer>(tmp), res);
        dfs(root.right, target - root.val, new ArrayList<Integer>(tmp), res);
        tmp.remove(tmp.size() - 1);
    }
}