package medium;

import java.util.LinkedList;
import java.util.Stack;
import util.TreeNode;
/**
 * 
 * ClassName: BinarySearchTreeIterator
 * @author chenyiAlone  
 * Create Time: 2019/02/09 19:38:16
 * Description: No.173
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
    
    Calling next() will return the next smallest number in the BST.
    
    Example:
    
    BSTIterator iterator = new BSTIterator(root);
    iterator.next();    // return 3
    iterator.next();    // return 7
    iterator.hasNext(); // return true
    iterator.next();    // return 9
    iterator.hasNext(); // return true
    iterator.next();    // return 15
    iterator.hasNext(); // return true
    iterator.next();    // return 20
    iterator.hasNext(); // return false
     
    Note:
    
    next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 */
public class BinarySearchTreeIterator {
    LinkedList<Integer> res = new LinkedList<>();
    public BinarySearchTreeIterator(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        return res.pop();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return res.size() != 0;    
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */