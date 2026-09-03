public class Task_06 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;

        // Iterative version (already used in previous tasks)
        long start = System.nanoTime();
        int idxIter = binarySearchIterative(arr, target);
        long end = System.nanoTime();
        System.out.println("Iterative Binary Search: found at " + idxIter + ", time = " + (end - start) + " ns");

        // Recursive version
        start = System.nanoTime();
        int idxRec = binarySearchRecursive(arr, target, 0, arr.length - 1);
        end = System.nanoTime();
        System.out.println("Recursive Binary Search: found at " + idxRec + ", time = " + (end - start) + " ns");
    }

    // Iterative – space O(1)
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Recursive – space O(log n) due to call stack
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return binarySearchRecursive(arr, target, mid + 1, high);
        else
            return binarySearchRecursive(arr, target, low, mid - 1);
    }
}