package easy;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;
/**
 * ClassName: PathSumIII.java
 * Author: chenyiAlone
 * Create Time: 2019/8/19 22:40
 * Description: No.437 Path Sum III
 * 思路:
 *      1. 记录每个结点到根的数值，用数值和个数组成 map 的键值对
 *      2. 先序遍历，将当前节点的值加到 root 到当前位置的之前的和上
 *      3. 查找 map 是否有 sum - target 的值，增加到 ans 中
 *      4. 进入 dfs 时，map 中的 key 为 sum += 1
 *         退出 dfs 时，map 中的 key 为 sum -= 1
 *
 *
 *
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 */
public class PathSumIII {
    private Map<Integer, Integer> map = new HashMap<>();
    private int target = 0;
    private int ans = 0;

    private void dfs(TreeNode root, int sum) {
        sum += root.val;
        if (map.containsKey(sum - target)) {
            ans += map.get(sum - target);
        }
        if (!map.containsKey(sum)) map.put(sum, 0);
        map.put(sum, map.get(sum) + 1);

        if (root.left != null) dfs(root.left, sum);
        if (root.right != null) dfs(root.right, sum);
        map.put(sum, map.get(sum) - 1);
    }

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        if (root == null) return 0;
        map.put(0, 1);
        dfs(root, 0);
        return ans;
    }
}
