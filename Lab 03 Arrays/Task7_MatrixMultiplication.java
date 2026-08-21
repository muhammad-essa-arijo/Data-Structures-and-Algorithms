/*
    Write a Java method that takes two 2D arrays (matrices) of integers as input and returns their product as a new 2D array.
    The method should handle cases where the matrices cannot be multiplied due to incompatible dimensions.
 */

public class Task7_MatrixMultiplication {
    public static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Incompatible matrices");
        }

        int[][] C = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] result = multiply(A, B);
        System.out.println("Product:");
        printMatrix(result); // 19 22 ; 43 50
    }
}