/*
    Write a Java program to check if two arrays are equal without using equal method.
*/

public class Task2_ArrayEqual {
    public static boolean areEqual(int[] a, int[] b) {
        if (a == null || b == null) return a == b;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {1, 2, 3, 5};
        System.out.println("arr1 == arr2 ? " + areEqual(arr1, arr2)); // true
        System.out.println("arr1 == arr3 ? " + areEqual(arr1, arr3)); // false
    }
}