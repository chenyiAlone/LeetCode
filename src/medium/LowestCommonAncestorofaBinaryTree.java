package medium;

import util.TreeNode;
/**
 * ClassName: LowestCommonAncestorofaBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/5/14 14:37
 * Description: No.236
 * 思路:
 *      1. 第一个想法:
 *---------------------------- code ---------------------------------------
 *
 * public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 *         if (root == null)
 *             return root;
 *         TreeNode left = lowestCommonAncestor(root.left, p, q);
 *         TreeNode right = lowestCommonAncestor(root.right, p, q);
 *         if (root == p || root == q)
 *             return root;
 *         if ((left == p && right == q) || (left == q && right == p))
 *             return root;
 *         else
 *             return left != null ? left : right;
 *     }
 * --------------------------- code ----------------------------------------
 *      2. 参考了讨论区的解法，发现自己的条件判断中有很多重复的部分,单独看返回值，只有如下五种情况
 *          1. ca 为 p q 中一个直接返回
 *              p            p
 *             /              \
 *            q                q
 *
 *          2. p q 作为子节点在两侧子树中，或者在同侧子树
 *
 *               ca               ca
 *              /  \             /
 *             q    p          p-q
 *
 *
 *
 *
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }
}