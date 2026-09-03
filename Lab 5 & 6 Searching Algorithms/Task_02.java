import java.util.ArrayList;
import java.util.Collections;

public class Task_02 {
    public static void main(String[] args) {
        // Create and sort an ArrayList of Integers
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); list.add(20); list.add(30); list.add(40); list.add(50);
        Collections.sort(list);  // binary search requires sorted list

        int target = 30;

        // Linear search
        long start = System.nanoTime();
        int indexLin = linearSearch(list, target);
        long end = System.nanoTime();
        System.out.println("Linear Search (ArrayList): target " + target + " at index " + indexLin +
                            ", time = " + (end - start) + " ns");

        // Binary search (using Java's built-in or custom)
        start = System.nanoTime();
        int indexBin = binarySearch(list, target);
        end = System.nanoTime();
        System.out.println("Binary Search (ArrayList): target " + target + " at index " + indexBin +
                            ", time = " + (end - start) + " ns");
    }

    public static <T> int linearSearch(ArrayList<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target))
                return i;
        }
        return -1;
    }

    // Custom binary search for ArrayList of Comparable elements
    public static <T extends Comparable<T>> int binarySearch(ArrayList<T> list, T target) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = list.get(mid).compareTo(target);
            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}