package medium;
/**
 * ClassName: BattleshipsinaBoard.java
 * Author: chenyiAlone
 * Create Time: 2019/8/15 23:09
 * Description: No.419 Battleships in a Board
 * 思路：
 *      对每个 X 进行判断
 *      1. 这个 X 的左边也为 X 就跳过
 *      2. 这个 X 的左边不为 X 并且他的右边为 X，ret += 1
 *      3. 左右都不为 X
 *          1. 上变为 X 直接跳过
 *          2. 下边为 X ret += 1
 *
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty
 * slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN
 * (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 *
 */
public class BattleshipsinaBoard {

    private boolean isX(int x, int y, int n, int m, char[][] board) {
        return x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 'X';
    }

    public int countBattleships(char[][] board) {
        int n, m, ret = 0;
        if ((n = board.length) == 0 || (m = board[0].length) == 0) return ret;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isX(i, j, n, m, board)) {
                    if (isX(i, j - 1, n, m, board)) continue;

                    if (isX(i, j + 1, n, m, board)) {
                        ret += 1;
                        continue;
                    }

                    if (isX(i - 1, j, n, m, board)) continue;

                    ret += 1;
                }
            }
        }
        return ret;
    }
}