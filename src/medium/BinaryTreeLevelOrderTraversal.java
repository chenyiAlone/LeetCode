package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;
/**
 * 
 * ClassName: BinaryTreeLevelOrderTraversal
 * @author chenyiAlone  
 * Create Time: 2019/01/23 19:16:16
 * Description: No.102
 * 总结：
 *     1. 层次遍历需要将每一层逐一遍历
 *     2. 使用栈入栈顺序需要保持为先右后左
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 
     * @param root 根节点
     * @return 层次遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            LinkedList<TreeNode> temp = new LinkedList<>();
            List<Integer> ans = new LinkedList<>();
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                ans.add(t.val);
                if (t.right != null) temp.push(t.right);
                if (t.left != null) temp.push(t.left);
            }
            res.add(ans);
            stack = temp;
        }
        return res;
    }
}
