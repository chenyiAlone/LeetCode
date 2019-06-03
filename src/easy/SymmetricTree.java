package easy;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * ClassName: SymmetricTree
 * @author chenyiAlone  
 * Create Time: 2019/01/22 21:17:46
 * Description: No.101
 *
 * -------------------- update -------------------
 * datetime: 2019/6/3
 *
 * 讨论中发现了使用 DFS 来遍历的一个问题，就是如果当前的两个节点的左子树很长，右子树再很短的位置就失配了，
 * 因为 DFS 总是按照一个方向进行深入，只有在退出左子树的 DFS 时候才会开始右子树，这就造成了一定的时间浪费，
 * 失配节点一下的位置其实是不用进行判断的，所以增加了 BFS 的解题方法
 *
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    
        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following [1,2,2,null,3,null,3] is not:
        1
       / \
      2   2
       \   \
       3    3
    Note:
    Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

    public boolean isSymmetricBFS(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode root1 = queue.poll(), root2 = queue.poll();
            if (root1 != null && root2 != null && root1.val == root2.val){
                queue.offer(root1.left);
                queue.offer(root2.right);

                queue.offer(root1.right);
                queue.offer(root2.left);
            } else if (!(root1 == null && root2 == null)) {
                return false;
            }
        }
        return true;
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkNode(root.left, root.right);
    }

    private static boolean checkNode(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null && t1.val == t2.val) {
            return checkNode(t1.left, t2.right) && checkNode(t1.right, t2.left);
        } else {
            return false;
        }
    }

}
