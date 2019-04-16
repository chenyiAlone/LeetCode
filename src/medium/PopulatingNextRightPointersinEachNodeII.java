package medium;

import java.util.ArrayList;
import java.util.List;

import util.Node;
/**
 * 
 * ClassName: PopulatingNextRightPointersinEachNodeII
 * @author chenyiAlone  
 * Create Time: 2019/04/16 16:28:29
 * Description: No.117
 * 思路:
 * 一、
 *   1. dummy 虚拟结点用添加子左右节点， 来通过 .next 连接下一层节点，
 *   2. 更新 cur = dummy.next 也就是下一层的第一个的节点，该层节点已经在上一层遍历的过程中通过 .next 连接
 *   3. 遍历到最左端的节点的子节点的时候(null), beak return root
 * 
 * 二、
 *   1. dfs 中序遍历 + list 记录上一结点 ，缺点， 空间复杂度 O(lg N) 应该不是常数级别
 * 
 * Given a binary tree
    
    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    
    Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 */
public class PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0);
            Node tmp = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    tmp.next = cur.left;
                    tmp = tmp.next;
                }
                if (cur.right != null) {
                    tmp.next = cur.right;
                    tmp = tmp.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
    public Node connectByDFS(Node root) {
        List<Node> pervs = new ArrayList<>();
        dfs(root, pervs, 0);
        return root;
    }
    
    
    
    private void dfs(Node root, List<Node> pervs, int level) {
        if (root == null)
            return;
        if (pervs.size() < level + 1)
            pervs.add(root);
        dfs(root.left, pervs, level + 1);
        if (pervs.get(level) != root) {
            pervs.get(level).next = root;
            pervs.set(level, root);
        }
        dfs(root.right, pervs, level + 1);
    }
    
    
}