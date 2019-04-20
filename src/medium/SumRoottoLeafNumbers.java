package medium;

import util.TreeNode;
/**
 * 
 * ClassName: SumRoottoLeafNumbers
 * @author chenyiAlone  
 * Create Time: 2019/04/20 13:25:20
 * Description: No.129
 * 思路:
 *     这道题的解是 Discuss 上的，真的是被这思路经验到了，
 *     1. s 用来统计从根节点到当前节点的值
 *     2. 只有当叶子节点才会返回 s * 10 + root.val 的值，否则返回 0
 *     
 *     
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
    
    An example is the root-to-leaf path 1->2->3 which represents the number 123.
    
    Find the total sum of all root-to-leaf numbers.
    
    Note: A leaf is a node with no children.
    
    Example:
    
    Input: [1,2,3]
        1
       / \
      2   3
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.
    Example 2:
    
    Input: [4,9,0,5,1]
        4
       / \
      9   0
     / \
    5   1
    Output: 1026
    Explanation:
    The root-to-leaf path 4->9->5 represents the number 495.
    The root-to-leaf path 4->9->1 represents the number 491.
    The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return handler(root, 0);
    }
    
    int handler(TreeNode root, int s) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return s * 10 + root.val;
        return handler(root.left, s * 10 + root.val) + handler(root.right, s * 10 + root.val);
    }
}