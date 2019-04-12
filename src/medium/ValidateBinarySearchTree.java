package medium;

import util.TreeNode;
/**
 * 
 * ClassName: ValidateBinarySearchTree
 * @author chenyiAlone  
 * Create Time: 2019/04/12 17:57:07
 * Description: No.98
 * 思路:
 *    1. 一个节点对应两个边界 ld + rd, ld = Long.MIN_VALUE + rd = Long.MAX_VALUE
 *    2. 判定结点的值是否为在这个区间之中
 *    3. 更新区间  return dfs(root.left, ld, root.val) && dfs(root.right, root.val, rd)
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
    
    Assume a BST is defined as follows:
    
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:
    
    Input:
        2
       / \
      1   3
    Output: true
    Example 2:
    
        5
       / \
      1   4
         / \
        3   6
    Output: false
    Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
                 is 5 but its right child's value is 4.
 * 
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        new ValidateBinarySearchTree().isValidBST(root);
    }
    boolean dfs(TreeNode root, long ld, long rd) {
        if (root == null)
            return true;
       if (root.val <= ld || root.val >= rd)
            return false;
        return dfs(root.left, ld, root.val) && dfs(root.right, root.val, rd);
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        long ld = Long.MIN_VALUE;
        long rd = Long.MAX_VALUE;
        return dfs(root, ld, rd);
    }
}