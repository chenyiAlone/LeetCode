package easy;

import util.TreeNode;
/**
 * 
 * ClassName: BalancedBinaryTree
 * @author chenyiAlone  
 * Create Time: 2019/01/25 19:57:38
 * Description: No.110
 * 总结：
 *     1. 平衡二叉树： 二叉树的任意节点的左右子树的高度差的绝对值不超过1
 *     2. 递归求得左右子树的高度
 * 
 * Given a binary tree, determine if it is height-balanced.
    
    For this problem, a height-balanced binary tree is defined as:
    
    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    
    Example 1:
    
    Given the following tree [3,9,20,null,null,15,7]:
    
        3
       / \
      9  20
        /  \
       15   7
    Return true.
    
    Example 2:
    
    Given the following tree [1,2,2,3,3,null,null,4,4]:
    
           1
          / \
         2   2
        / \
       3   3
      / \
     4   4
    Return false.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root);
    }
    public static boolean helper(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(hightOfTree(root.left) - hightOfTree(root.right)) < 2) {
            return helper(root.left) && helper(root.right);
        } else {
            return false;
        }
    }
    public static int hightOfTree(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(hightOfTree(root.left) + 1, hightOfTree(root.right) + 1);
    }
}
