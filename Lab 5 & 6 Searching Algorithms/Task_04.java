import java.util.LinkedList;
import java.util.ListIterator;

public class Task_04 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5); linkedList.add(12); linkedList.add(7); linkedList.add(3); linkedList.add(21);
        int target = 7;

        long start = System.nanoTime();
        int index = linearSearchLinkedList(linkedList, target);
        long end = System.nanoTime();

        if (index != -1)
            System.out.println("Linear Search on LinkedList: found " + target + " at index " + index +
                                ", time = " + (end - start) + " ns");
        else
            System.out.println("Linear Search on LinkedList: not found");
    }

    public static <T> int linearSearchLinkedList(LinkedList<T> list, T target) {
        int index = 0;
        for (T element : list) {        // uses iterator internally – O(n) total
            if (element.equals(target))
                return index;
            index++;
        }
        return -1;
    }
}