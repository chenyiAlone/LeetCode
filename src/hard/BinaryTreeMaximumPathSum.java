package hard;

import util.TreeNode;
/**
 * 
 * ClassName: BinaryTreeMaximumPathSum
 * @author chenyiAlone  
 * Create Time: 2019/04/19 17:26:40
 * Description: No.124
 * 思路:
 *     提议要求的是所有节点即可，并不是非要从叶子节点走上来， 比如:
 *                   2
 *                  / \
 *                -1   1
 *                
 *       这种情况的答案为 2，而不是 0
 *     
 *     1. DFS
 *     2. dfs 返回当前节点所在子树最大的返回值
 *     3. ans 保存一下最大的结果
 * 
 * 
 * 
 * Given a non-empty binary tree, find the maximum path sum.
    
    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
    
    Example 1:
    
    Input: [1,2,3]
    
           1
          / \
         2   3
    
    Output: 6
    Example 2:
    
    Input: [-10,9,20,null,null,15,7]
    
       -10
       / \
      9  20
        /  \
       15   7
    
    Output: 42
 */
public class BinaryTreeMaximumPathSum {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return ans;
    }
    
    public int dfs(TreeNode root) {
        int val = root.val;
        int leftVal = 0, rightVal = 0;
        if (root.left != null) {
            leftVal = Math.max(0, dfs(root.left));
        }
        if (root.right != null) {
            rightVal = Math.max(0, dfs(root.right));
        }
        int sum = leftVal + rightVal + val;
        ans = Math.max(sum, ans);
        return val + Math.max(leftVal, rightVal);
    }
}