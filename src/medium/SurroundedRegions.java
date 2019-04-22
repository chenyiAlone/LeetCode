package medium;

import java.util.LinkedList;
/**
 * 
 * ClassName: SurroundedRegions
 * @author chenyiAlone  
 * Create Time: 2019/04/22 17:15:26
 * Description: No.130
 * 思路:
 *     1. 边界上为 O 的点向内部蔓延，这些都没有被包围
 *     2. 遍历四条边界，将为 O 位置添加到 Queue 中，并将 check 对应位置置为 true
 *     3. 遍历 Queue，BFS 向四个方向蔓延，如果相邻的四个方向存在为 O 并且 check 对应位置为 false 的就更新为 true
 *     4. 将 check 对应的 board 点置为 X
 *     
 *      
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
    
    A region is captured by flipping all 'O's into 'X's in that surrounded region.
    
    Example:
    
    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:
    
    X X X X
    X X X X
    X X X X
    X O X X
    Explanation:
    
    Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that 
    is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.     
 * 
 */
public class SurroundedRegions {
    private class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public void solve(char[][] board) {
        if (board == null)
            return;
        int m = board.length;
        if (m == 0)
            return;
        int n = board[0].length;
        if (n == 0)
            return;
        // column
        boolean[][] check = new boolean[m][n];
        LinkedList<Pair> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                check[i][0] = true;
                que.offer(new Pair(i, 0)); 
            }
                
            if (board[i][n - 1] == 'O') {
                check[i][n - 1] = true;
                que.offer(new Pair(i, n - 1));
            }
                
                
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                check[0][i] = true;
                que.offer(new Pair(0, i));
            }
            if (board[m - 1][i] == 'O') {
                check[m - 1][i] = true;
                que.offer(new Pair(m - 1, i));
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        while (!que.isEmpty()) {
            
            Pair pair = que.poll();
            int x = pair.first;
            int y = pair.second;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n && check[x][y] && !check[nx][ny] && board[nx][ny] == 'O') {
                    System.out.println(nx + " " + ny);
                    check[nx][ny] = true;
                    que.offer(new Pair(nx, ny));
                    
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j])
                    board[i][j] = 'X';
            }
        }
    }
}