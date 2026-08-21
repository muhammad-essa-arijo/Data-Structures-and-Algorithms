/*
    Use all of the array method discussed above in your java code but array should not be of type integer.
    Use String type array.
*/

import java.util.Arrays;

public class Task3_ArrayOperationsString {
    private String[] arr;
    private int size; // logical size

    public Task3_ArrayOperationsString(int capacity) {
        arr = new String[capacity];
        size = 0;
    }

    // Traversal
    public void traverse() {
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Search (returns index or -1)
    public int search(String key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(key)) return i;
        }
        return -1;
    }

    // Insert at given index
    public void insert(int index, String value) {
        if (index < 0 || index > size || size == arr.length) {
            System.out.println("Insertion failed (invalid index or full)");
            return;
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    // Delete at given index
    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Deletion failed (invalid index)");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null; // optional
    }

    // Sort (using Arrays.sort on a copy of the logical part)
    public void sort() {
        String[] temp = new String[size];
        System.arraycopy(arr, 0, temp, 0, size);
        Arrays.sort(temp);
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public static void main(String[] args) {
        Task3_ArrayOperationsString ops = new Task3_ArrayOperationsString(10);
        ops.insert(0, "apple");
        ops.insert(1, "banana");
        ops.insert(1, "cherry");
        ops.insert(2, "date");
        ops.traverse(); // apple cherry date banana ?

        System.out.println("Search 'date': " + ops.search("date")); // 2
        ops.delete(1);
        ops.traverse(); // apple date banana
        ops.sort();
        ops.traverse(); // apple banana date
    }
}