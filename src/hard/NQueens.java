package hard;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: NQueens
 * @author chenyiAlone  
 * Create Time: 2019/03/21 15:41:52
 * Description: No.51
 * 思路;
 *   1. 皇后问题的核心点就是使用 DFS + BackTracking
 *   2. 每次尝试都会进行换行，所以不许进行行判断
 *   3. 判断一个点是不是另一个点的对角线元素， i => row, j => col, if (i + col == j + row || i + j == row + col)
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    
    
    
    Given an integer n, return all distinct solutions to the n-queens puzzle.
    
    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
    
    Example:
    
    Input: 4
    Output: [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],
    
     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfsNqueens(0, board, res);
        return res;
    }
    
    public void dfsNqueens(int l, char[][] board, List<List<String>> res) {
        if (l == board.length) {
            res.add(change(board));
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (check(l, i, board)) {
                board[l][i] = 'Q';
                dfsNqueens(l + 1, board, res);
                board[l][i] = '.';
            }
            
        }
    }
    
    public boolean check(int l, int c, char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 'Q' && (i + j == l + c || i + c == j + l || c == j))
                    return false;
            }
        }
        return true;
    }
    
    public List<String> change(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] cs : board) {
            list.add(new String(cs));
        }
        return list;
    }
}
