package easy;

import util.TreeNode;
/**
 * ClassName: LowestCommonAncestorofaBinarySearchTree.java
 * Author: chenyiAlone
 * Create Time: 2019/5/14 13:03
 * Description: No.235
 * 思路:
 *      1. 因为是个 BST ,根据大小关系递归查找
 *      2. 满足条件的情况:
 *              root.val 处于 [p.val, q.val] 之间// 忽略大小
 *
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
 * p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 *
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        int rv = root.val, pv = p.val, qv = q.val;
        if ((pv <= rv && rv <= qv) || (qv <= rv && rv <= pv))
            return root;
        if (pv < rv && qv < rv)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }
}
