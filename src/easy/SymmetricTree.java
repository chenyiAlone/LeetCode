package easy;

import util.TreeNode;

/**
 * 
 * ClassName: SymmetricTree
 * @author chenyiAlone  
 * Create Time: 2019/01/22 21:17:46
 * Description: No.101
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    
        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following [1,2,2,null,3,null,3] is not:
        1
       / \
      2   2
       \   \
       3    3
    Note:
    Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkNode(root.left, root.right);
    }
    public static boolean checkNode(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null && t1.val == t2.val) {
            return checkNode(t1.left, t2.right) && checkNode(t1.right, t2.left);
        } else {
            return false;
        }
        
    }
}
