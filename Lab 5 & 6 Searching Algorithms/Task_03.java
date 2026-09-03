public class Task_03 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 16;

        // Linear search (flattened)
        long start = System.nanoTime();
        int[] posLin = linearSearch2D(matrix, target);
        long end = System.nanoTime();
        if (posLin[0] != -1)
            System.out.println("Linear Search 2D: found " + target + " at (" + posLin[0] + ", " + posLin[1] + ")" +
                                ", time = " + (end - start) + " ns");
        else
            System.out.println("Linear Search 2D: not found");

        // Binary search (treat as 1D)
        start = System.nanoTime();
        int[] posBin = binarySearch2D(matrix, target);
        end = System.nanoTime();
        if (posBin[0] != -1)
            System.out.println("Binary Search 2D: found " + target + " at (" + posBin[0] + ", " + posBin[1] + ")" +
                                ", time = " + (end - start) + " ns");
        else
            System.out.println("Binary Search 2D: not found");
    }

    // Linear search – returns {row, col} or {-1,-1}
    public static int[] linearSearch2D(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    // Binary search on a row‑major sorted 2D array
    public static int[] binarySearch2D(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;
        int low = 0, high = rows * cols - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int val = arr[row][col];
            if (val == target)
                return new int[]{row, col};
            else if (val < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return new int[]{-1, -1};
    }
}