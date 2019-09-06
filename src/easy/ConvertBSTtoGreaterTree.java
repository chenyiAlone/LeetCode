package easy;

import util.TreeNode;
/**
 * ClassName: ConvertBSTtoGreaterTree.java
 * Author: chenyiAlone
 * Create Time: 2019/9/6 8:05
 * Description: No.538 Convert BST to Greater Tree
 * 思路:
 *      r-> root-> l 的顺序来遍历，然后 pre 保存之前的累加和
 *
 *
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 *
 */
public class ConvertBSTtoGreaterTree {
    private int pre = 0;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        int oldVal= root.val;
        root.val += pre;
        pre += oldVal;
        dfs(root.left);
    }


    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
}