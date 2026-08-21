/*
    Write a Java method that takes a 2D array (matrix) of integers as input and sorts each row of the matrix in ascending order.
    The method should modify the original matrix and return void.
 */

import java.util.Arrays;

public class Task6_SortMatrix {
    public static void sortMatrixRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {5, 2, 9},
            {1, 7, 3},
            {8, 4, 6}
        };
        System.out.println("Original:");
        printMatrix(mat);
        sortMatrixRows(mat);
        System.out.println("Sorted (each row):");
        printMatrix(mat);
    }
}