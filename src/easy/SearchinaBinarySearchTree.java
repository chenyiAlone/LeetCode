package easy;

import util.*;
/**
 * ClassName: SearchinaBinarySearchTree.java
 * Author: chenyiAlone
 * Create Time: 2019/10/26 22:24
 * Description: No.700 Search in a Binary Search Tree
 */
public class SearchinaBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }

}