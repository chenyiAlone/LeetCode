package medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
//        int rows = matrix[0].length;
//        int columns = matrix.length;
//        System.out.println("rows = " + rows + " columns = " + columns);
        List<Integer> ans = new LinkedList<>();
        int step = 1;
        int y = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans.add(matrix[i][y]);
                if (j != matrix[i].length - 1)y += step;
            }
            step = -step;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {  {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9, 10}
                        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
