package easy;

import java.util.*;
import util.*;

/**
 * ClassName: NaryTreePostorderTraversal.java
 * Author: chenyiAlone
 * Create Time: 2019/10/6 19:37
 * Description: No.590 N-ary Tree Postorder Traversal
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Return its postorder traversal as: [5,6,3,2,4,1].
 *
 *  
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 */
public class NaryTreePostorderTraversal {
    private List<Integer> ret = new ArrayList<>();

    private void dfs(Node root) {
        if (root == null) return;
        for (Node n : root.children) {
            dfs(n);
        }
        ret.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        dfs(root);
        return ret;
    }

}
