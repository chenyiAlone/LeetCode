package easy;

import java.util.*;
import util.*;


/**
 * ClassName: MinimumDistanceBetweenBSTNodes.java
 * Author: chenyiAlone
 * Create Time: 2019/10/29 23:02 
 * Description: No.783 Minimum Distance Between BST Nodes
 */
public class MinimumDistanceBetweenBSTNodes {

    private boolean start = true;
    private int pre = 0;
    private int ret = Integer.MAX_VALUE;
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (start) {
            pre = root.val;
            start = false;
        } else {
            ret = Math.min(ret, Math.abs(root.val - pre));
            pre = root.val;
        }
        dfs(root.right);
    }
    
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ret;
    }

}