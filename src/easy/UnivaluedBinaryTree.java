package easy;

import util.TreeNode;
/**
 * ClassName: UnivaluedBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/11/25 20:41
 * Description: No.965 Univalued Binary Tree
 *
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 * Example 1:
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: [2,2,2,5,2]
 * Output: false
 *
 * Note:
 *
 * The number of nodes in the given tree will be in the range [1, 100].
 * Each node's value will be an integer in the range [0, 99].
 *
 */
public class UnivaluedBinaryTree {

    private boolean dfs(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val == val)
            return dfs(root.left, val) && dfs(root.right, val);
        return false;
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        else return dfs(root, root.val);
    }

}