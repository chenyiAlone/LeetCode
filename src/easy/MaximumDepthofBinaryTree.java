package easy;

import util.TreeNode;

/**
 * 
 * ClassName: MaximumDepthofBinaryTree
 * @author chenyiAlone  
 * Create Time: 2019/01/06 22:32:23
 * Description: No.104
 * Given a binary tree, find its maximum depth.
    
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    
    Note: A leaf is a node with no children.
    
    Example:
    
    Given binary tree [3,9,20,null,null,15,7],
    
        3
       / \
      9  20
        /  \
       15   7
    return its depth = 3.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        return depthRec(root);
    }
    public static int depthRec(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) {
            return 1 + depthRec(root.right);
        } else if (root.right == null) {
            return 1 + depthRec(root.left);
        } else {
            return 1 + Math.max(depthRec(root.left), depthRec(root.right));
        }
            
    }
}
