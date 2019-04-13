package medium;

import util.TreeNode;
/**
 * 
 * ClassName: ConstructBinaryTreefromPreorderandInorderTraversal
 * @author chenyiAlone  
 * Create Time: 2019/04/13 10:19:39
 * Description: No.105
 * 思路:
 *    1. 难点是 当一个值被找到的时候, per_index需要 += 1，java 中不能通过地址改变数值，使用全局变量代替
 *    2. lb 和 rb 代表在 inorder[] 中的查找边界
 *    3. return 
 *         a. 当边界失效(lb > rb) 或者inroder[] 这个区间找不到 preorder[pre_index]
 *         b. return null, lb == rb return inorder[lb]
 *         c. cur.left = dfs(lb, cur_index - 1);
 *            cur.rigth = dfs(cur_index + 1, rb);
 *            return cur;
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private int pre_index = 0;
    
    private TreeNode dfs(int lb, int rb, int[] preorder, int[] inorder) {
        if (lb > rb)
            return null;
        TreeNode cur = null;
        int root_index = -1;
        for (int i = lb; i <= rb && lb < inorder.length; i++) {
            if (inorder[i] == preorder[pre_index]) {
                root_index = i;
            }
        }
        if (root_index == -1) {
            return cur;
        } else {
            cur = new TreeNode(inorder[root_index]);
            pre_index++;
            TreeNode lson = dfs(lb, root_index - 1, preorder, inorder);
            TreeNode rson = dfs(root_index + 1, rb, preorder, inorder);
            cur.left = lson;
            cur.right = rson;    
        }
        return cur;
        
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        return dfs(0, len - 1, preorder ,inorder);
    }
}