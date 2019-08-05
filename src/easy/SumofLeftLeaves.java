package easy;

import util.TreeNode;

/**
 * ClassName: SumofLeftLeaves.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 23:56
 * Description: No.404 Sum of Left Leaves
 *
 *Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumofLeftLeaves {

    private int dfs(TreeNode root, boolean isLeft) {
        int ret = 0;
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) return root.val;
        if (root.left != null) ret += dfs(root.left, true);
        if (root.right != null) ret += dfs(root.right, false);
        return ret;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

}