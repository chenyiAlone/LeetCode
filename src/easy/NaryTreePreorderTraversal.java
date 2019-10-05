package easy;

import java.util.*;
import util.*;

/**
 * ClassName: NaryTreePreorderTraversal.java
 * Author: chenyiAlone
 * Create Time: 2019/10/5 22:08
 * Description: No.589 N-ary Tree Preorder Traversal
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 *
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 *  
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 *
 */
public class NaryTreePreorderTraversal {
    private List<Integer> ret = new ArrayList<>();

    private void dfs(Node root) {
        if (root == null) return;
        ret.add(root.val);
        for (Node n : root.children)
            dfs(n);
    }

    public List<Integer> preorder(Node root) {
        dfs(root);
        return ret;
    }
}