package medium;

import java.util.*;

/**
 * ClassName: ZeroOneMatrix.java
 * Author: chenyiAlone
 * Create Time: 2019/11/26 22:33 
 * Description: No.542 0 1 Matrix
 */
public class ZeroOneMatrix {

    private class Pair {
        int x;
        int y;
        Pair() {}
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] ret = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                } else
                    ret[i][j] = Integer.MAX_VALUE;
            }
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i], ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ret[nx][ny] > ret[p.x][p.y] + 1) {
                    ret[nx][ny] = ret[p.x][p.y] + 1;
                    queue.offer(new Pair(nx, ny));
                }

            }
        }
        return ret;
    }

}