package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.TreeNode;
/**
 * 
 * ClassName: BinaryTreeZigZagLevelOrderTraversal
 * @author chenyiAlone  
 * Create Time: 2019/02/01 22:54:18
 * Description: No.103
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
    
    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, root);
        for (int i = 1; i < res.size(); i += 2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
    public static void helper(List<List<Integer>> res, int rank, TreeNode root) {
        if (root == null) return;
        if (res.size() - 1 < rank) {
            res.add(new ArrayList<Integer>());
        }
        res.get(rank).add(root.val);
        helper(res, rank + 1, root.left);
        helper(res, rank + 1, root.right);
    }
}
