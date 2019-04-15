package medium;

import util.TreeNode;
import java.util.LinkedList;
/**
 * 
 * ClassName: FlattenBinaryTreetoLinkedList
 * @author chenyiAlone  
 * Create Time: 2019/04/15 17:34:00
 * Description: No.114
 * 思路:
 *   1. 先序遍历整个树，保存在  list 中
 *   2. 左子树置为 null，右子树连接下一个节点
 *   
 * 
 * 
 * Given a binary tree, flatten it to a linked list in-place.
    
    For example, given the following tree:
    
        1
       / \
      2   5
     / \   \
    3   4   6
    The flattened tree should look like:
    
    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6
 *   
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        TreeNode ans = null;
        LinkedList<TreeNode> list = new LinkedList<>();
        prevOrder(root, list);
        while (!list.isEmpty()) {
            if (ans == null) {
                ans = list.poll();
            } else {
                ans.right = list.poll();
                ans.left = null;
                ans = ans.right;
            }
        }
    }
    
    public void prevOrder(TreeNode root, LinkedList<TreeNode> list) {
        if (root == null)
            return;
        list.add(root);
        prevOrder(root.left, list);
        prevOrder(root.right, list);
    }
}