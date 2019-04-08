package medium;
/**
 * 
 * ClassName: WordSearch
 * @author chenyiAlone  
 * Create Time: 2019/04/08 16:36:44
 * Description: No.79
 * 思路：
 *    1. DFS + BackTracking + trakc[m][n] 保证每个元素只使用一次
 *    2. 起点 dfs(i, j, board, 1, str, track);
 *    3. 题目要求必须垂直或者水平方向，所以向上/下/左/右,四个方向延伸
 *             int[] dx = {-1, 1, 0, 0};
 *             int[] dy = {0, 0, -1, 1};
 */
public class WordSearch {
    private boolean ans = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0)
            return ans;
        int n = board[0].length;
        if (n == 0)
            return ans;
        char[] str = word.toCharArray();
        boolean[][] track = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n && !ans; j++) {
                if (board[i][j] == str[0]) {
                    track[i][j] = true;
                    dfs(i, j, board, 1, str, track);
                    track[i][j] = false;
                }
            }
        }
        return ans;
    }
    private void dfs(int x, int y, char[][] board, int index, char[] str, boolean[][] track) {
        if (index == str.length || ans) {
            ans = true;
            return;
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            boolean flag = (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && !ans && str[index] == board[nx][ny] && !track[nx][ny]);
            if (flag) {
                track[nx][ny] = true;
                dfs(nx, ny, board, index + 1, str, track);
                track[nx][ny] = false;
            }
        }
    }
}