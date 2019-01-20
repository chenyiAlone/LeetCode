package medium;

public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
                        };
        new Searcha2DMatrix().setZeroes(matrix);
        
    }
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int lines = matrix[0].length;
        int[][] oldMatrix = new int[rows][lines];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lines; j++) {
                oldMatrix[i][j] = matrix[i][j];
            }
        }
        System.out.println("rows = " + rows + "  line = " + lines);
        boolean[][] bm = new boolean[rows][lines];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lines; j++) {
                if (oldMatrix[i][j] == 0 && bm[i][j] == false) setRowLineZore(i, j, matrix, bm);
                printArray(matrix);
                printArray(bm);
            }
//            
        }
        printArray(matrix);
        printArray(bm);
        
    }
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int t : array[i]) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
        
    }
    public static void printArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (boolean t : array[i]) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
        
    }
    public static void setRowLineZore(int row, int line, int[][] matrix, boolean[][] bm) {
        int rows = matrix.length;
        int lines = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lines; j++) {
                if ((i == row || j == line) && bm[i][j] == false) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
