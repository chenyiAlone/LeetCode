package medium;

import util.TreeNode;
import java.util.ArrayList;
import java.util.List;
/**
 * ClassName: BinaryTreeRightSideView.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/6 16:31
 * Description: No.199
 * 思路:
 *      1. DFS root-> root.rightTree-> root.leftTree
 *      2. depth 记录当前深度，当 list.size() <= depth 的时候，将当前节点加入 list
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 */
public class BinaryTreeRightSideView {
    private void dfs(int depth, List<Integer> res, TreeNode root) {
        if (res.size() <= depth) {
            res.add(root.val);
        }
        if (root.right != null)
            dfs(depth + 1, res, root.right);
        if (root.left != null)
            dfs(depth + 1, res, root.left);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(0, res, root);
        return res;
    }
}