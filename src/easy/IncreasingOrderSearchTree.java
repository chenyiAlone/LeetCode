package easy;

import util.*;

/**
 * ClassName: IncreasingOrderSearchTree.java
 * Author: chenyiAlone
 * Create Time: 2019/11/23 20:25 
 * Description: No.897 Increasing Order Search Tree
 */
public class IncreasingOrderSearchTree {

    private TreeNode ret, cur;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (ret == null) {
            ret = new TreeNode(root.val);
            cur = ret;
        } else {
            cur.right = new TreeNode(root.val);
        cur = cur.right;
        }
        dfs(root.right);
        
    }

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return ret;
    }

}