package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import util.TreeNode;
/**
 * 
 * ClassName: BinaryTreePostorderTraversal
 * @author chenyiAlone  
 * Create Time: 2019/02/03 22:24:44
 * Description: No.145
 * 总结:
 *     1. 节点右子树被访问完成后就会被访问
 *     2. pre 记录被访问的最后一个节点
 *     3. cur.right != null && cur.right != pre
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
    
    Example:
    
    Input: [1,null,2,3]
       1
        \
         2
        /
       3
    
    Output: [3,2,1]
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.right != null && cur.right != pre) {
                    stack.push(cur);
                    cur = cur.right;
                } else {
                    res.add(cur.val);
                    pre = cur;
                    cur = null;
                }
            }
        }
        return res;
    }
}
