/*
    Write and test the following methods:
        0. Implement Create Read Update & Delete (CRUD) Operations to LinkedList.
        1.int search(int x) //returns the index of element in the linked list
        2.int size() //returns the size of the linked list
        3.int sum() //returns the sum of all numbers in the linked list
        4.void deleteLast() //deletes the last node in the list
        5.LinkedList copy() //returns a new linked list that is the duplicate of the list this
        method is called up on.
        6.LinkedList subList(int p, int q) //returns a new linked list that contains element
        from node p to node q of the list this method is called up on.
        7.void append(LinkedList l) //l is appended to the list this method is called on.
        8.LinkedList merged(Linked l) // returns a new list that mer
*/

public class part1 {
    // Node class for internal list elements
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;         // keeps track of list size for O(1) size()

    // ---------- Constructors ----------
    public part1() {
        head = null;
        size = 0;
    }

    // Convenience: build list from an array
    public part1(int[] values) {
        this();
        for (int v : values) {
            add(v);
        }
    }

    // ---------- CRUD Operations ----------
    // Create (adds at the end)
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Read (get value at index)
    public int get(int index) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Update (set value at index)
    public void set(int index, int value) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = value;
    }

    // Delete (remove node at index)
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    // Helper to validate index
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // ---------- 1. search ----------
    // Returns index of first occurrence of x, or -1 if not found
    public int search(int x) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == x) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // ---------- 2. size ----------
    public int size() {
        return size;
    }

    // ---------- 3. sum ----------
    public int sum() {
        int total = 0;
        Node current = head;
        while (current != null) {
            total += current.data;
            current = current.next;
        }
        return total;
    }

    // ---------- 4. deleteLast ----------
    public void deleteLast() {
        if (head == null) {
            return; // or throw exception if preferred
        }
        if (size == 1) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    // ---------- 5. copy ----------
    // Returns a new part1 that is a duplicate of this list
    public part1 copy() {
        part1 newList = new part1();
        Node current = head;
        while (current != null) {
            newList.add(current.data);
            current = current.next;
        }
        return newList;
    }

    // ---------- 6. subList ----------
    // Returns a new list containing elements from index p to q (inclusive)
    // If p > q, or invalid indices, returns an empty list.
    public part1 subList(int p, int q) {
        part1 sub = new part1();
        if (p < 0 || q >= size || p > q) {
            return sub; // empty list
        }
        Node current = head;
        for (int i = 0; i < p; i++) {
            current = current.next;
        }
        for (int i = p; i <= q; i++) {
            sub.add(current.data);
            current = current.next;
        }
        return sub;
    }

    // ---------- 7. append ----------
    // Appends all elements of list l to the end of this list
    public void append(part1 l) {
        if (l == null || l.head == null) {
            return;
        }
        // Copy nodes from l to avoid aliasing issues (if we want independent lists)
        // If we just link the tail to l.head, modifications to l would affect this list.
        // We'll create a deep copy of l's nodes.
        Node current = l.head;
        while (current != null) {
            this.add(current.data);
            current = current.next;
        }
    }

    // ---------- 8. merged ----------
    // Returns a new sorted list that merges this list and l, assuming both are sorted ascending.
    // Does not modify this list or l.
    public part1 merged(part1 l) {
        part1 result = new part1();
        Node a = this.head;
        Node b = l.head;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                result.add(a.data);
                a = a.next;
            } else {
                result.add(b.data);
                b = b.next;
            }
        }
        // Add remaining elements from either list
        while (a != null) {
            result.add(a.data);
            a = a.next;
        }
        while (b != null) {
            result.add(b.data);
            b = b.next;
        }
        return result;
    }

    // ---------- Utility: toString ----------
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // ---------- Testing ----------
    public static void main(String[] args) {
        System.out.println("=== Testing LinkedList ===\n");

        // Create initial list [10, 20, 30, 40, 50]
        part1 list = new part1(new int[]{10, 20, 30, 40, 50});
        System.out.println("Original list: " + list);

        // 0. CRUD
        System.out.println("\n--- CRUD ---");
        // Read
        System.out.println("get(2) = " + list.get(2));          // 30
        // Update
        list.set(2, 35);
        System.out.println("After set(2,35): " + list);        // [10,20,35,40,50]
        // Delete
        list.remove(1);
        System.out.println("After remove(1): " + list);        // [10,35,40,50]
        // Create (add)
        list.add(60);
        System.out.println("After add(60): " + list);          // [10,35,40,50,60]

        // 1. search
        System.out.println("\n--- search ---");
        System.out.println("search(40) = " + list.search(40));  // 2
        System.out.println("search(99) = " + list.search(99));  // -1

        // 2. size
        System.out.println("\n--- size ---");
        System.out.println("size() = " + list.size());          // 5

        // 3. sum
        System.out.println("\n--- sum ---");
        System.out.println("sum() = " + list.sum());            // 10+35+40+50+60 = 195

        // 4. deleteLast
        System.out.println("\n--- deleteLast ---");
        list.deleteLast();
        System.out.println("After deleteLast: " + list);       // [10,35,40,50]

        // 5. copy
        System.out.println("\n--- copy ---");
        part1 copy = list.copy();
        System.out.println("Original: " + list);
        System.out.println("Copy:     " + copy);
        copy.add(100);  // modify copy independently
        System.out.println("After adding 100 to copy: " + copy);
        System.out.println("Original remains:         " + list);

        // 6. subList
        System.out.println("\n--- subList ---");
        part1 sub = list.subList(1, 3);
        System.out.println("subList(1,3) of " + list + " = " + sub); // [35,40,50]
        part1 emptySub = list.subList(2, 1);
        System.out.println("subList(2,1) = " + emptySub);             // []

        // 7. append
        System.out.println("\n--- append ---");
        part1 other = new part1(new int[]{70, 80});
        System.out.println("Before append: " + list);
        list.append(other);
        System.out.println("After append(70,80): " + list);   // [10,35,40,50,70,80]
        // Verify other is unchanged
        System.out.println("Other list unchanged: " + other);

        // 8. merged
        System.out.println("\n--- merged ---");
        part1 sortedA = new part1(new int[]{1, 3, 5, 7});
        part1 sortedB = new part1(new int[]{2, 4, 6, 8});
        System.out.println("A: " + sortedA);
        System.out.println("B: " + sortedB);
        part1 merged = sortedA.merged(sortedB);
        System.out.println("Merged (ascending): " + merged);  // [1,2,3,4,5,6,7,8]
        // Ensure originals are not modified
        System.out.println("A unchanged: " + sortedA);
        System.out.println("B unchanged: " + sortedB);

        // Edge cases
        System.out.println("\n--- Edge cases ---");
        part1 empty = new part1();
        System.out.println("Empty list: " + empty);
        System.out.println("size() = " + empty.size());
        System.out.println("sum() = " + empty.sum());
        empty.deleteLast(); // should do nothing
        System.out.println("After deleteLast on empty: " + empty);
        part1 mergedWithEmpty = empty.merged(new part1(new int[]{5, 6}));
        System.out.println("empty.merged([5,6]) = " + mergedWithEmpty);
    }
}