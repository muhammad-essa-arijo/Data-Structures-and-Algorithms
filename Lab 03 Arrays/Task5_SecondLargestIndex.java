/* 
    Write a Java method that takes an array of integers as input and returns the index of the second largest element.
    If there is no second largest element, return -1.
 */

public class Task5_SecondLargestIndex {
    public static int secondLargestIndex(int[] arr) {
        if (arr == null || arr.length < 2) return -1;

        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v > max) {
                secondMax = max;
                max = v;
            } else if (v > secondMax && v != max) {
                secondMax = v;
            }
        }
        if (secondMax == Integer.MIN_VALUE) return -1; // no second distinct

        // find first index of secondMax
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == secondMax) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int idx = secondLargestIndex(arr);
        System.out.println("Second largest element index: " + idx); // 4 (value 34)
    }
}