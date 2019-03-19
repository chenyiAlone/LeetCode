package hard;

/**  
 * ClassName: SudokuSolver
 * @author chenyiAlone  
 * Create Time: 2019/03/19 16:55:33
 * Description: No.37
 * 思路:
 *    深度优先搜索 + 回溯
 *    
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
    
    A sudoku solution must satisfy all of the following rules:
    
    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    Empty cells are indicated by the character '.'.
    
    
    A sudoku puzzle...
    
    
    ...and its solution numbers marked in red.
    
    Note:
    
    The given board contain only digits 1-9 and the character '.'.
    You may assume that the given Sudoku puzzle will have a single unique solution.
    The given board size is always 9x9. 
 */   
public class SudokuSolver {
    private boolean found = false;
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        DFSfileBoard(board, 0, 0);
    }
    
    public void DFSfileBoard(char[][] board, int l, int c) {
        if (c == 9 && l == 8) {
            found = true;
            util.Utils.printCharArray(board);
            return;
        }
        if (found) return;
        if (c == 9) {
            c = 0;
            l += 1;
        }
        if (board[l][c] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if (check(l, c, board, i)) {
                    board[l][c] = i;
                    DFSfileBoard(board, l, c + 1);
                }
                // 回溯法的精髓，重置原先的值才能实现退步回溯
                board[l][c] = '.';
            }
        } else {
            DFSfileBoard(board, l, c + 1);
        }
    }
    
    public boolean check(int l, int c, char[][] board, char n) {
        for (int i = 0; i < 9; i++) 
            if (board[i][c] == n || board[l][i] == n)
                return false;
        int tl = (l / 3) * 3;
        int tc = (c / 3) * 3; 
//        System.out.println(tl + " " + tc);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[tl + i][tc + j] == n)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] board2 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
                };
        new SudokuSolver().solveSudoku(board);
//        System.out.println(new SudokuSolver().check(0, 0, board2, '5'));
    }
}
