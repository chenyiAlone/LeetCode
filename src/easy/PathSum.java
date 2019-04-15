package easy;

import util.TreeNode;
/**
 * 
 * ClassName: PathSum
 * @author chenyiAlone  
 * Create Time: 2019/04/15 17:26:44
 * Description: No.112
 * 思路:
 *    1. DFS
 *    2. 判断是否为叶子节点 rtarget == root.val && root.left == null
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    
    Note: A leaf is a node with no children.
    
    Example:
    
    Given the below binary tree and sum = 22,
    
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }
    
    private boolean dfs(TreeNode root, int target) {
        if (root != null && target == root.val && root.left == null && root.right == null)
            return true;
        if (root == null)
            return false;
        return dfs(root.left, target - root.val) || dfs(root.right, target - root.val);
    }
}