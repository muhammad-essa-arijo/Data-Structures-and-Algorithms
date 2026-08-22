/*
    Explore java.util.LinkedList class; Create a linked list of type String using this
    class and apply any 5 of its predefined methods.
*/

import java.util.LinkedList;

public class part3 {
    public static void main(String[] args) {
        // 1. Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // 2. Add elements (method: add)
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        System.out.println("Initial list: " + list);

        // 3. Access an element by index (method: get)
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit);

        // 4. Update an element (method: set)
        list.set(1, "Blueberry");
        System.out.println("After set(1, Blueberry): " + list);

        // 5. Remove an element by index (method: remove)
        String removed = list.remove(3);
        System.out.println("Removed element at index 3: " + removed);
        System.out.println("After remove(3): " + list);

        // 6. Get the size of the list (method: size)
        System.out.println("Current size of list: " + list.size());

        // Extra demonstration: contains and addFirst (beyond 5, just for fun)
        System.out.println("Contains 'Apple'? " + list.contains("Apple"));
        list.addFirst("Apricot");
        System.out.println("After addFirst: " + list);
    }
}