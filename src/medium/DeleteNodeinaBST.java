package src.medium;

import java.util.*;

public class DeleteNodeinaBST {
    private void delete(TreeNode xp, TreeNode x) {
        if (x.val < xp.val) {
            xp.left = null;
        } else {
            xp.right = null;
        }
    }
    
    private TreeNode rotate(TreeNode xp, TreeNode x) {
        if (xp.val < x.val) { // left
            xp.right = x.left;
            x.left = xp;
            return x;
        
        } else { // right
            xp.left = x.right;
            x.right = xp;
            return x;
        }
    }
    
    private void repair(TreeNode xp, TreeNode x) {
        if (x.val < xp.val) {
            xp.left = x;
        } else {
            xp.right = x;
        }
    }
    
    private void dfs(TreeNode x, TreeNode xp, int key) {
        if (x == null) return;
        if (x.val == key) {
            
            if (x.left == null && x.right == null) {
                delete(xp, x);
                return;
            } else if (x.right == null) {
                x = rotate(x, x.left);
                repair(xp, x);
                dfs(x.right, x, key);
            } else {
                x = rotate(x, x.right);
                repair(xp, x);
                dfs(x.left, x, key);
            } 
        } else if (x.val > key) {
            dfs(x.left, x, key);
        } else {
            dfs(x.right, x, key);
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode guard = new TreeNode(Integer.MAX_VALUE);
        guard.left = root;
        dfs(root, guard, key);
        return guard.left;
    }
    
}