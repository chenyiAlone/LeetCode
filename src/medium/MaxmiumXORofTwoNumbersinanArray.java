package medium;
/**
 * ClassName: MaxmiumXORofTwoNumbersinanArray.java
 * Author: chenyiAlone
 * Create Time: 2019/8/16 23:25
 * Description: No.421 Maximum XOR of Two Numbers in an Array
 * 思路:
 *      1. 构造一个串树，每个结点有 0 1 两个方向代表这一位为 0 还是为 1，树的每一条路径就代表一个数，每条路径相互独立
 *      2. 使用 & 操作，取得每个数对应的 32 位的串树
 *      3. 按照异或的关系进行 dfs
 *              该位可以形成异或的四种情况:
 *                  ^= 1, depth - 1, val | (1 << depth)
 *                  ^= 0, depth - 1, val | (1 << depth)
 *
 *
 *
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 *
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 *
 * Could you do this in O(n) runtime?
 *
 * Example:
 *
 * Input: [3, 10, 5, 25, 2, 8]
 *
 * Output: 28
 *
 * Explanation: The maximum result is 5 ^ 25 = 28.
 *
 */
public class MaxmiumXORofTwoNumbersinanArray {

    private int ret;

    private class Node {
        Node[] son = new Node[2];
    }
    private void dfs(Node a, Node b, int depth, int val) {
        ret = Math.max(ret, val);
        if (depth < 0) return;

        boolean flag = true;

        if (a.son[1] != null && b.son[0] != null) {
            dfs(a.son[1], b.son[0], depth - 1, val | (1 << depth));
            flag = false;
        }
        if (a.son[0] != null && b.son[1] != null) {
            dfs(a.son[0], b.son[1], depth - 1, val | (1 << depth));
            flag = false;
        }
        if (flag) {
            for (int i = 0; i < 2; i++) {
                if (a.son[i] != null && b.son[i] != null)
                    dfs(a.son[i], b.son[i], depth - 1, val);
            }
        }
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for (int i : nums) {
            Node cur = root;
            for (int j = 1 << 30; j > 0; j >>>= 1) {
                int t = (i & j) > 0 ? 1 : 0;
                if (cur.son[t] == null)
                    cur.son[t] = new Node();
                cur = cur.son[t];
            }
        }
        dfs(root, root, 30, 0);
        return ret;
    }

}