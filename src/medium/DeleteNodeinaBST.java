package medium;

import util.TreeNode;

/**
 * ClassName: DeleteNodeinaBST.java
 * Author: chenyiAlone
 * Create Time: 2019/9/4 7:33
 * Description: No.250 Delete Node in a BST
 * 思路:
 *      1. 通过左旋和右旋将节点旋转到一个左右子树都为 null 的位置，然后将其删除
 *      2. 使用 guard 哨兵节点来代表的根节点的父节点，解决只有一个根节点删除时候的特出情况
 *      3. 删除和旋转操作都根据传入的父子节点的大小关系来进行
 *          1). 旋转
 *                  子节点 < 父节点，右旋
 *                          2
 *                         / \
 *                        1   n
 *
 *                   父节点 < 子节点，左旋
 *                          3
 *                         / \
 *                        n   4
 *
 *           2). 删除，只有左右节点都为 null，才会将 x 从父节点上删除
 *
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 */
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