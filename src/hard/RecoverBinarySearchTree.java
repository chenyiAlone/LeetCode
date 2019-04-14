package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;
/**
 * 
 * ClassName: RecoverBinarySearchTree
 * @author chenyiAlone  
 * Create Time: 2019/04/14 10:56:17
 * Description: No.99
 * 思路:
 *     真是差点被这个题给搞死了，其实回头想想自己是真的菜，只要先序遍历整棵树，记录下两个非升序对的位置交换就可以了
 *     1. TreeNode prev 表示前结点，
 *          a. if (prev != null && prev.val > cur.val) 将这个逆序对放入 list 中
 *          b. prev = cur;
 *     2. 递归和非递归两种方式就没什么可说的的了
 *     
 *     
 *     
 * Two elements of a binary search tree (BST) are swapped by mistake.
    
    Recover the tree without changing its structure.
    
    Example 1:
    
    Input: [1,3,null,null,2]
    
       1
      /
     3
      \
       2
    
    Output: [3,1,null,null,2]
    
       3
      /
     1
      \
       2
    Example 2:
    
    Input: [3,1,4,null,null,2]
    
      3
     / \
    1   4
       /
      2
    
    Output: [2,1,4,null,null,3]
    
      2
     / \
    1   4
       /
      3
    Follow up:
    
    A solution using O(n) space is pretty straight forward.
    Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    TreeNode prev = null;
    List<TreeNode> res = new ArrayList<>();
    public void recoverTreeNonRecursive(TreeNode root) {
        // traversal(root);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (prev != null && prev.val > cur.val) {
                    res.add(prev);
                    res.add(cur);
                }
                prev = cur;
                cur = cur.right;
            }
        }
        int tmp = res.get(0).val;
        res.get(0).val = res.get(res.size() - 1).val;
        res.get(res.size() - 1).val = tmp;
    }
    
    public void recoverTree(TreeNode root) {
        traversal(root);
        int tmp = res.get(0).val;
        res.get(0).val = res.get(res.size() - 1).val;
        res.get(res.size() - 1).val = tmp;
    }
    
    void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        if (prev == null) {
            prev = root;
        } else {
            if (prev.val > root.val) {
                res.add(prev);
                res.add(root);
            }
            prev = root;
        }
        traversal(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        System.out.println(root);
    }
}