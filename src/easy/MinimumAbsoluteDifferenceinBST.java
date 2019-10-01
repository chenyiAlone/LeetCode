package easy;

import util.*;

/**
 * ClassName: MinimumAbsoluteDifferenceinBST.java
 * Author: chenyiAlone
 * Create Time: 2019/10/1 9:30
 * Description: No.530 Minimun Absolute Difference in BST
 */

public class MinimumAbsoluteDifferenceinBST {

    private int ret = Integer.MAX_VALUE;
    private int pre = -1;
    
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        ret = Math.min(ret, pre == -1 ? Integer.MAX_VALUE : Math.abs(root.val - pre));
        pre = root.val;
        dfs(root.right);
    }
    
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ret;
    }
    
}