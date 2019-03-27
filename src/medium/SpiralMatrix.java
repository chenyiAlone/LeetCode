package medium;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * ClassName: SpiralMatrix
 * @author chenyiAlone  
 * Create Time: 2019/03/27 16:19:26
 * Description: No.54
 * 思路:
 *   1. 使用 step 用于列的更新
 *   2. 使用 y 来表示 matrix 的列坐标
 *   3. 循环完一层后，更改 step 的方向
 */
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
                if (j != matrix[i].length - 1)
                    y += step;
            }
            step = -step;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {  {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
