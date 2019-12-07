package easy;

import util.*;

/**
 * ClassName: SumofRootToLeafBinaryNumbers.java
 * Author: chenyiAlone
 * Create Time: 2019/12/7 23:21
 * Description: No.1022 Sum of Root To Leaf Binary Numbers
 */
public class SumofRootToLeafBinaryNumbers {

    private int ret = 0;

    private void dfs(TreeNode root, int temp) {
        if (root.left == null && root.right == null) ret += temp * 2 + root.val;
        else {
            if (root.left != null)
                dfs(root.left, temp * 2 + root.val);
            if (root.right != null)
                dfs(root.right, temp * 2 + root.val);
        }
        
    }

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ret;
    }
    
}