package medium;
/**
 * 
 * ClassName: ValidSudoku
 * @author chenyiAlone  
 * Create Time: 2019/03/15 17:28:03
 * Description: No.36
  * 总结:
  *        题目给出的要求中表名，数独不一定可解，只需要判断已经存在的元素，所以代码的思路无非是判断被检测的元素所在的行和列，
  *        以及所在这一组是否有重复元素，当这个元素为 ".: 的时候 continue 这次循环
 *        
 *            
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    
    A partially filled sudoku which is valid.
    
    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    
    Example 1:
    
    Input:
    [
      ["5","3",".",".","7",".",".",".","."],
      ["6",".",".","1","9","5",".",".","."],
      [".","9","8",".",".",".",".","6","."],
      ["8",".",".",".","6",".",".",".","3"],
      ["4",".",".","8",".","3",".",".","1"],
      ["7",".",".",".","2",".",".",".","6"],
      [".","6",".",".",".",".","2","8","."],
      [".",".",".","4","1","9",".",".","5"],
      [".",".",".",".","8",".",".","7","9"]
    ]
    Output: true
    Example 2:
    
    Input:
    [
      ["8","3",".",".","7",".",".",".","."],
      ["6",".",".","1","9","5",".",".","."],
      [".","9","8",".",".",".",".","6","."],
      ["8",".",".",".","6",".",".",".","3"],
      ["4",".",".","8",".","3",".",".","1"],
      ["7",".",".",".","2",".",".",".","6"],
      [".","6",".",".",".",".","2","8","."],
      [".",".",".","4","1","9",".",".","5"],
      [".",".",".",".","8",".",".","7","9"]
    ]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being 
        modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    Note:
    
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
    The given board contain only digits 1-9 and the character '.'.
    The given board size is always 9x9.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean res = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                res = res && checkRow(board, i, j);
                System.out.println(res);
                res = res && checkColumn(board, i, j);
                System.out.println(res);
                res = res && checkGroup(board, i, j);
                System.out.println("r:" + i + " c:" + j + "  =" + res);
            }
        }
        return res;
    }
    public static boolean checkColumn(char[][] board, int m, int n) {
        for (int i = 0; i < 9; i++) {
            if (board[i][n] == board[m][n] && i != m) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkRow(char[][] board, int m, int n) {
        for (int i = 0; i < 9; i++) {
            if (board[m][i] == board[m][n] && i != n) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkGroup(char[][] board, int m, int n) {
        int row = m / 3, column = n / 3;
        for (int i = 3 * row; i < 3 * row + 3; i++) {
            for (int j = 3 * column; j < 3 * column + 2; j++) {
                if (board[i][j] == board[m][n] && (m != i || n != j)) {
                    return false;
                }
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
//        System.out.println(checkRow(board, 0, 1));
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}