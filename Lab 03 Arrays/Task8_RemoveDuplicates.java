/*
    Write a Java method that takes an array of integers as input and removes duplicate elements from the array.
    The method should return the new length of the array after duplicates have been removed.
*/

import java.util.*;

public class Task8_RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        if (arr == null) return 0;
        Set<Integer> set = new LinkedHashSet<>();
        for (int v : arr) set.add(v);
        // Copy back to original array (or create new array)
        int i = 0;
        for (int v : set) {
            arr[i++] = v;
        }
        // Optionally nullify remaining elements
        for (; i < arr.length; i++) {
            arr[i] = 0; // not necessary, but we only care about new length
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] sample = {20, 20, 30, 40, 50, 50, 50};
        int newLen = removeDuplicates(sample);
        System.out.print("New Array: ");
        for (int i = 0; i < newLen; i++) {
            System.out.print(sample[i] + (i == newLen-1 ? "" : ", "));
        }
        System.out.println("\nLength: " + newLen);
        // Output: New Array: 20, 30, 40, 50   Length: 4
    }
}