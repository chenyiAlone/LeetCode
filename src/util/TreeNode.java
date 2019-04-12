package util;

import java.util.LinkedList;

/**
 * 
 * ClassName: TreeNode
 * @author chenyiAlone  
 * Create Time: 2019/01/06 22:33:03
 * Description: LeetCode commion class
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(this);
        for (; que.size() > 0; que.poll()) {
            TreeNode tmp = que.peek();
            str.append((tmp == null ? "null" : tmp.val) + ", ");
            if (tmp != null) {
                que.add(tmp.left);
                que.add(tmp.right);
            }
        }
        str.deleteCharAt(str.length() - 1).append("]");
        return str.toString();
    }
}
