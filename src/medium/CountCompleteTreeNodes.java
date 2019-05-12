package medium;

import util.TreeNode;
/**
 * ClassName: CountCompleteTreeNodes.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/12 10:57
 * Description: No.222
 * 思路:
 *      从最后一层从右向左，找出第一个满足数高的点（从左向右也可）
 *      1. iter 想最左端遍历得出 depth 树的高度
 *      2. offset 记录偏移量，当回溯的时候，证明 dfs 右子树时并没有得到结果，offset += 1
 *      3. 满二叉树的结点数 2 ^ depth - 1
 *          res = (int)Math.pow(2, depth) - 1 - offset;
 *
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 *
 */
public class CountCompleteTreeNodes {
    private int res = 0;
    private int depth = 1;
    private int offset = 0;
    private boolean found = false;

    private void dfs(TreeNode root, int curDepth) {
        if (found)
            return;
        if (root == null) {
            if (curDepth == depth) {
                res = (int) Math.pow(2, depth) - 1 - offset;
                found = true;
            }
        } else {
            dfs(root.right, curDepth + 1);
            offset += 1;
            dfs(root.left, curDepth + 1);
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return res;
        TreeNode iter = root;
        while (iter.left != null) {
            depth += 1;
            iter = iter.left;
        }
//        System.out.println(depth);
        dfs(root, 0);
        return res;
    }
}
