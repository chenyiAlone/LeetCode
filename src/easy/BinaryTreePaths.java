package easy;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName: BinaryTreePaths.java
 * Author: chenyiAlone
 * Create Time: 2019/5/15 16:56
 * Description: No.257
 * 思路:
 *      DFS + BackTracking
 *
 *
 *
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 *
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null)
            dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder path, List<String> res) {
        if (path.length() == 0)
            path.append(root.val);
        else
            path.append("->").append(root.val);
        int len = path.length();
        if (root.left != null) {
            dfs(root.left, path, res);
            path.setLength(len);
        }
        if (root.right != null) {
            dfs(root.right, path, res);
            path.setLength(len);
        }
        if (root.left == null && root.right == null)
            res.add(path.toString());
    }
}