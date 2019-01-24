package medium;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;
/**
 * 
 * ClassName: BinaryTreeLevelOrderTraversalll
 * @author chenyiAlone  
 * Create Time: 2019/01/24 20:10:25
 * Description: No.107
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
    
    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return res;
        stack.offer(root);
        while (!stack.isEmpty()) {
            LinkedList<TreeNode> temp = new LinkedList<>();
            List<Integer> ans = new LinkedList<>();
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                ans.add(t.val);
                if (t.left != null) temp.offer(t.left);
                if (t.right != null) temp.offer(t.right);
            }
            res.push(ans);
            stack = temp;
        }
        return res;
    }
}
