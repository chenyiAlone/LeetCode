package easy;

import util.*;

/**
 * ClassName: SecondMinimumNodeInaBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/10/31 21:23
 * Description: No.671 Second Minimum Node In a Binary Tree
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *  
 *
 * Example 2:
 *
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 */
public class SecondMinimumNodeInaBinaryTree {

    private int[] ret = {-1, -1};

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (ret[0] == -1) ret[0] = root.val;
        else {
            if (ret[1] == -1) {
                if (root.val < ret[0]) {
                    ret[1] = ret[0];
                    ret[0] = root.val;
                } else if (root.val > ret[0]) {
                    ret[1] = root.val;
                }
            } else {
                if (root.val < ret[1] && root.val > ret[0]) {
                    ret[1] = root.val;
                } else if (root.val < ret[0]) {
                    ret[1] = ret[0];
                    ret[0] = root.val;
                }
            }
        }
        dfs(root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return ret[1];
    }

}