package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import util.TreeNode;
/**
 * 
 * ClassName: BinaryTreeInorderTraversal
 * @author chenyiAlone  
 * Create Time: 2019/01/31 20:54:40
 * Description: No.94
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
    
    Example:
    
    Input: [1,null,2,3]
       1
        \
         2
        /
       3
    
    Output: [1,3,2]
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                res.add(temp.val);
                temp = temp.right;
            }
        }
        return res;
    }
}
