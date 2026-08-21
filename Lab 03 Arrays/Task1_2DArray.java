/*
    Write a Java Code, get no of rows & columns from user and take some Random
    integer values from user. Apply On One & Two Dimensional Array. And print it in
    matrix form. Must take input using JOptionPane Class.
*/

import javax.swing.JOptionPane;

public class Task1_2DArray {
    public static void main(String[] args) {
        // Input rows and columns
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rows:"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Enter number of columns:"));

        int[][] matrix = new int[rows][cols];

        // Fill with random values (0–99) and display using JOptionPane
        StringBuilder inputMsg = new StringBuilder("Enter values (row by row):\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String val = JOptionPane.showInputDialog("Enter value for [" + i + "][" + j + "]:");
                matrix[i][j] = Integer.parseInt(val);
            }
        }

        // Print matrix
        StringBuilder output = new StringBuilder("Matrix:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                output.append(matrix[i][j]).append("\t  ");
            }
            output.append("\n");
        }
        JOptionPane.showMessageDialog(null, output.toString());

        // Also demonstrate 1D array
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter size of 1D array:"));
        int[] oneD = new int[size];
        for (int i = 0; i < size; i++) {
            oneD[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter value for index " + i + ":"));
        }
        StringBuilder out1D = new StringBuilder("1D Array: ");
        for (int v : oneD) out1D.append(v).append(" ");
        JOptionPane.showMessageDialog(null, out1D.toString());
    }
}