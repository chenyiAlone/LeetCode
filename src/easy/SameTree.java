package easy;

import util.TreeNode;

/**
 * 
 * ClassName: SameTree
 * @author chenyiAlone  
 * Create Time: 2019/01/15 18:55:44
 * Description: No.100
 * Given two binary trees, write a function to check if they are the same or not.
    
    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
    
    Example 1:
    
    Input:     1         1
              / \       / \
             2   3     2   3
    
            [1,2,3],   [1,2,3]
    
    Output: true
    Example 2:
    
    Input:     1         1
              /           \
             2             2
    
            [1,2],     [1,null,2]
    
    Output: false
    Example 3:
    
    Input:     1         1
              / \       / \
             2   1     1   2
    
            [1,2,1],   [1,1,2]
    
    Output: false
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p == null && q == null) return true;
        
        boolean isSame = p.val == q.val;
        return isSame && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
