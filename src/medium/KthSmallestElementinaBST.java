package medium;

import util.TreeNode;
/**
 * ClassName: KthSmallestElementinaBST.java
 * Author: chenyiAlone
 * Create Time: 2019/5/13 17:07
 * Description: No.230
 * 思路:
 *      1. DFS 找到最左边的节点，也就是最小的节点，找到偏移 k 的节点就得到了结果
 *      2. curK 记录的就是也就是所以为相对于最左边节点的偏移量，更新条件为
 *
 *              if (root.left != null)
 *                  dfs(root.left, k);
 *              if (root.right != null)
 *                  dfs(root.rigth, k - 1);
 *              curK += 1;
 *
 *
 *
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 *
 */
public class KthSmallestElementinaBST {
    private int curK = 0;
    private int res = -1;
    private boolean found = false;
    private void dfs(TreeNode root, int k) {
        if (found)
            return;
        if (root.left != null)
            dfs(root.left, k);
        if (curK == k && !found) {
            res = root.val;
            found = true;
            return;
        }
        if (root.right != null && !found) {
            dfs(root.right, k - 1);
        }
        curK += 1;
    }

    public int kthSmallest(TreeNode root, int k) {
        curK = 1;
        dfs(root, k);
        return res;
    }
}