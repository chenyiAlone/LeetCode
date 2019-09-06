package easy;

import util.TreeNode;

/**
 * ClassName: BinaryTreeTilt.java
 * Author: chenyiAlone
 * Create Time: 2019/9/6 7:58
 * Description: No.563 Binary Tree Tilt
 * 思路:
 *      返回当前结点所在的整个子树的和
 *
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 *
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 */
public class BinaryTreeTilt {

    private int ret = 0;

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ret += Math.abs(left - right);
        return left + root.val + right;
    }

    public int findTilt(TreeNode root) {
        dfs(root);
        return ret;
    }
}