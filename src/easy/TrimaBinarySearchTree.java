package easy;

import util.*;

/**
 * ClassName: TrimaBinarySearchTree.java
 * Author: chenyiAlone
 * Create Time: 2019/1/4 22:36
 * Description: No.669 Trim a Binary Search Tree
 */
public class TrimaBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) { 
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

}