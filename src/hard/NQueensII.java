package hard;
/**
 * 
 * ClassName: NQueensII
 * @author chenyiAlone  
 * Create Time: 2019/03/27 16:10:46
 * Description: No.52
 * 思路：
 *       与上一题中 N-Queens 思路相同，只需要统计一下所有的结果的个数即可
 *   1. 皇后问题的核心点就是使用 DFS + BackTracking
 *   2. 每次尝试都会进行换行，所以不许进行行判断
 *   3. 判断一个点是不是另一个点的对角线元素， i => row, j => col, if (i + col == j + row || i + j == row + col)
 * 
 */
public class NQueensII {
    private int res = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfsNqueens(0, board);
        return res;
    }
    
    public void dfsNqueens(int l, char[][] board) {
        if (l == board.length) {
            res++;
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (check(l, i, board)) {
                board[l][i] = 'Q';
                dfsNqueens(l + 1, board);
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
}
