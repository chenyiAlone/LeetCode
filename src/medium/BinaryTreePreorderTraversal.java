package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import util.TreeNode;
/**
 * 
 * ClassName: BinaryTreePreorderTraversal
 * @author chenyiAlone  
 * Create Time: 2019/02/02 19:54:31
 * Description: No.144
 * 总结:
 *     使用 stack 完成对树的先序遍历
 *     1. stack 中只需要存放 right节点
 *     2. 扫描到节点就把这个节点的值加到 res
 *     3. cur == null && stack.isEmpty()=> cur = stack.pop()
 * Given a binary tree, return the preorder traversal of its nodes' values.

    Example:
    
    Input: [1,null,2,3]
       1
        \
         2
        /
       3
    
    Output: [1,2,3]
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
