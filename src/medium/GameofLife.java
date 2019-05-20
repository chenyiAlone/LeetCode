package medium;
/**
 * ClassName: GameofLife.java
 * Author: chenyiAlone
 * Create Time: 2019/5/20 15:14
 * Description: No.289
 * 思路:
 *      1. 使用两个二进制位来保存状态，低位为原状态，高位为新状态
 *      2. 统计周围的 `cell` 个数，根据题目要求更新
 *
 *
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is
 * a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following
 * four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot
 * update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which
 * would cause problems when the active area encroaches the border of the array. How would you address these problems?
 *
 */
public class GameofLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0)
            return;
        int n = board[0].length;
        if (n == 0)
            return;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int dx = -1; dx < 2; dx++)
                    for (int dy = -1; dy < 2; dy++) {
                        if (0 <= i + dx && i + dx < m
                                && 0 <= j + dy && j + dy < n
                                && (board[i + dx][j + dy] & 1) == 1
                                && (dx != 0 || dy != 0)) {
                            cnt ++;
                        }
                    }
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3))
                        board[i][j] |= 2;
                else if (cnt == 3)
                        board[i][j] |= 2;
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] >>= 1;
    }
}