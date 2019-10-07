package easy;

import util.*;

/**
 * ClassName: ConstructStringfromBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/10/7 21:08
 * Description: No.606 Construct String from Binary Tree
 */
public class ConstructStringfromBinaryTree {
    
    private StringBuilder ret = new StringBuilder();
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        ret.append(root.val);
        if (root.left == null && root.right == null) return;
            ret.append('(');
            dfs(root.left);
            ret.append(')');
        if (root.right != null) {
            ret.append('(');
            dfs(root.right);
            ret.append(')');
        }
    }
    
    public String tree2str(TreeNode t) {
        dfs(t);
        return ret.toString();
    }

}