package easy;

import util.Node;
/**
 * ClassName: MaximumDepthofNaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/10/3 18:59
 * Description: No.559 Maximum Depth of N-ary Tree
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 *
 */
public class MaximumDepthofNaryTree {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ret = 1;
        for (Node n : root.children)
            ret = Math.max(ret, 1 + maxDepth(n));
        return ret;
    }

}
