package medium;

import java.util.LinkedList;
import java.util.Stack;
import util.TreeNode;
/**
 * ClassName: BinarySearchTreeIterator.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/5 13:27
 * Description: No.173
 * 思路:
 *      1. traceLeft(TreeNode root) 使用 stack 从上向下记录当前 root 节点以及它所有的 left 节点，并将 cur 更新为 stack.peek()
 *      2. next(): 返回 cur.val， cur 指向 cur.right，并且 stack.pop() 弹出顶端的 cur 原先指向的节点，并且 traceLeft(cur)
 *      3. hashNext(): return !stack.isEmpty() || cur != null;
 *
 *
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * Example:
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 *
 * Note:
 *
 *      next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *      You may assume that next() call will always be valid, that is, there will be at least a next smallest number
 *      in the BST when next() is called.
 *
 */
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<>();

    private TreeNode cur = null;

    private void traceLeft(TreeNode root) {
        if (root != null) {
            stack.push(root);
            if (root.left != null)
                traceLeft(root.left);
        }
        if (!stack.isEmpty())
            cur = stack.peek();

    }

    public BinarySearchTreeIterator(TreeNode root) {
        traceLeft(root);

    }

    /** @return the next smallest number */
    public int next() {
        int val = cur.val;
        cur = cur.right;
        stack.pop();
        traceLeft(cur);
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }
}