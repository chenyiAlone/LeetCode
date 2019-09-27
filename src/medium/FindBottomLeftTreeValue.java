package medium;

import util.*;

/**
 * ClassName: FindBottomLeftTreeValue.java
 * Author: chenyiAlone
 * Create Time: 2019/9/27 22:05
 * Description: No.513 Find Bottom Left Tree Value
 */

public class FindBottomLeftTreeValue {    
    private int ret = -1;
    private int maxDepth = 0;
    
    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level > maxDepth) {
            maxDepth = level;
            ret = root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
    
    
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ret;
    }
}