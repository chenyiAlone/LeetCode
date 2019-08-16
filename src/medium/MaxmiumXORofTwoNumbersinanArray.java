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
}
