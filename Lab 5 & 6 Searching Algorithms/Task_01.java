import java.util.Arrays;

public class Task_01 {
    public static void main(String[] args) {
        // ----- String array (must be sorted for binary search) -----
        String[] strArray = {"apple", "banana", "cherry", "date", "elderberry"};
        String targetStr = "date";

        // Linear search on strings
        long start = System.nanoTime();
        int indexLinStr = linearSearch(strArray, targetStr);
        long end = System.nanoTime();
        System.out.println("Linear Search (String): target '" + targetStr + "' found at index " + indexLinStr +
                            ", time = " + (end - start) + " ns");

        // Binary search on strings (requires sorted array)
        start = System.nanoTime();
        int indexBinStr = binarySearch(strArray, targetStr);
        end = System.nanoTime();
        System.out.println("Binary Search (String): target '" + targetStr + "' found at index " + indexBinStr +
                            ", time = " + (end - start) + " ns");

        // ----- Character array (sorted) -----
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        char targetChar = 'd';

        start = System.nanoTime();
        int indexLinChar = linearSearch(charArray, targetChar);
        end = System.nanoTime();
        System.out.println("Linear Search (Char): target '" + targetChar + "' found at index " + indexLinChar +
                            ", time = " + (end - start) + " ns");

        start = System.nanoTime();
        int indexBinChar = binarySearch(charArray, targetChar);
        end = System.nanoTime();
        System.out.println("Binary Search (Char): target '" + targetChar + "' found at index " + indexBinChar +
                            ", time = " + (end - start) + " ns");
    }

    // ----- Generic linear search for any Comparable array -----
    public static <T extends Comparable<T>> int linearSearch(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(target) == 0)
                return i;
        }
        return -1;
    }

    // Overloaded for char (primitive)
    public static int linearSearch(char[] arr, char target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // ----- Generic binary search for Comparable array (iterative) -----
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(target);
            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Overloaded for char (primitive)
    public static int binarySearch(char[] arr, char target) {
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
}