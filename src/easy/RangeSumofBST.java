package easy;

import util.*;

/**
 * ClassName: RangeSumofBST.java
 * Author: chenyiAlone
 * Create Time: 2019/11/21 19:58
 * Description: No.938 Range Sum of BST
 */
public class RangeSumofBST {

    private int L, R;
    private int ret;
        
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (L <= root.val && root.val <= R) ret += root.val;
        dfs(root.right);
    }
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        this.ret = 0;
        this.L = L;
        this.R = R;
        dfs(root);
        return ret;
    }
    
}