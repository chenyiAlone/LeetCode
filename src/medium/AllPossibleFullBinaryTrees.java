package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.TreeNode;

/**
 * @author chenyiAlone
 * @date 2020/09/09 23:54
 *
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 *
 * Each node of each tree in the answer must have node.val = 0.
 *
 * You may return the final list of trees in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 *
 *  
 *
 * Note:
 *
 * 1 <= N <= 20
 *
 */
public class AllPossibleFullBinaryTrees {

    private List<TreeNode> ret = new ArrayList<>();

    private Map<Integer, List<TreeNode>> tmp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        return dfs(0, N - 1);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        if (start == end) {
            ret.add(new TreeNode(0));
            return ret;
        }
        if (tmp.containsKey(end - start)) {
            return tmp.get(end - start);
        }
        for (int i = start + 1; i < end; i++) {

            List<TreeNode> lefts = dfs(start, i - 1);
            List<TreeNode> rights = dfs(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }

        }
        tmp.put(end - start, ret);
        return ret;
    }

}