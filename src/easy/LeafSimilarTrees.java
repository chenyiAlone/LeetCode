package easy;

import java.util.*;
import util.*;


/**
 * ClassName: LeafSimilarTrees.java
 * Author: chenyiAlone
 * Create Time: 2019/12/17 18:03
 * Description: No.872 Leaf-Similar Trees
 *
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *  
 *
 * Note:
 *
 * Both of the given trees will have between 1 and 100 nodes.
 *
 */
public class LeafSimilarTrees {

    private boolean ret = true;
    private Queue<Integer> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();

    private void dfs(TreeNode root, Queue<Integer> queue) {
        if (!ret || root == null) return;
        dfs(root.left, queue);
        if (root.left == null && root.right == null) {
            queue.offer(root.val);
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                if (!queue1.poll().equals(queue2.poll())) {
                    ret = false;
                    return;
                }
            }
        }
        dfs(root.right, queue);

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, queue1);
        dfs(root2, queue2);
        return queue1.isEmpty() && queue2.isEmpty() && ret;
    }
}
