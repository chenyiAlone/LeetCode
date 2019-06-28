package medium;

import util.TreeNode;
import java.lang.Math;

import static java.lang.Math.max;

/**
 * ClassName: HouseRobberIII.java
 * Author: chenyiAlone
 * Create Time: 2019/6/28 20:16
 * Description: No.337
 * 思路:
 *      1. 树形 DP，dfs 返回 选和不选的最大值
 *      2. 更新条件，选和不选：
 *              // 不选从子节点的选和不选更新
 *              ret[0] = max(left[1], left[0]) + max(right[1], right[0]);
 *              // 选更新为 val + 子节点不选
 *              ret[1] = root.val + left[0] + right[0]
 *
 *
 */
public class HouseRobberIII {
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] ret = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        ret[1] = root.val + left[0] + right[0];
        ret[0] = max(left[0], left[1]) + max(right[0], right[1]);
        return ret;

    }
    public int rob(TreeNode root) {
        int[] ret = dfs(root);
        return max(ret[0], ret[1]);
    }
}
