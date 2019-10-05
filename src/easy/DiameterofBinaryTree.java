package easy;

import util.*;

/**
 * ClassName: DiameterofBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/10/4 21:40
 * Description: No.543 Diameter of Bianry Tree
 */

public class DiameterofBinaryTree {
   private int ans = 0;
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans == 0 ? 0 : ans - 1;
    }
}