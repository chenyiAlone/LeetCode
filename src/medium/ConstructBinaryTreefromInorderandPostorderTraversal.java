package medium;

import util.TreeNode;
/**
 * 
 * ClassName: ConstructBinaryTreefromInorderandPostorderTraversal
 * @author chenyiAlone  
 * Create Time: 2019/04/14 09:27:01
 * Description: No.106
 * 思路:
 *     1. dfs + post_index
 *     2. 思路与 No.105 基本相同，因为是后续遍历，所以需要先 dfs() 右边部分
 *     3. 边界条件的判断也从 lb < inorder.length 变为 rb >= 0
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    private int post_index = 0;
    private TreeNode dfs(int lb, int rb,  int[] inorder, int[] postorder) {
        if (lb > rb)
            return null;
        TreeNode tmp = null;
        if (lb == rb) {
            post_index--;
            return new TreeNode(inorder[lb]);
        }
        int cur = -1;
        for (int i = lb; i <= rb && rb >= 0; i++) {
            if (postorder[post_index] == inorder[i]) {
                cur = i;
                break;
            }
        }
        if (cur == -1) {
            return tmp;
        } else {
            post_index--;
            tmp = new TreeNode(inorder[cur]);
            TreeNode right = dfs(cur + 1, rb, inorder, postorder);
            TreeNode left = dfs(lb, cur - 1, inorder, postorder);
            tmp.left = left;
            tmp.right = right;
        }
        return tmp;
    }
    
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        post_index = len - 1;
        return dfs(0, len - 1, inorder, postorder);
    }
}
