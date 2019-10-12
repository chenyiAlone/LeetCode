package medium;

import util.*;
/**
 * ClassName: MaximumBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/10/12 21:14
 * Description: No.654 Maximum Binary Tree
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 *
 */
public class MaximumBinaryTree {

    private TreeNode dfs(int l, int r, int[] nums) {
        TreeNode ret = l == r ? new TreeNode(nums[l]) : null;
        if (l >= r) return ret;
        int mid = l;
        for (int i = l + 1; i <= r; i++) if (nums[i] > nums[mid]) mid = i;
        ret = new TreeNode(nums[mid]);
        ret.left = dfs(l, mid - 1, nums);
        ret.right = dfs(mid + 1, r, nums);
        return ret;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }
}