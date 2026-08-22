/*
    Implement a linked list for Student class. Student class should have roll_num
    and name as instance variables. The linked list should have the following operations:
        ◦ insert(Student s)
        ◦ delete(Student s)
        ◦ printList() // print the roll numbers and names of every student in the list
*/

class Student {
    private int roll_num;
    private String name;

    public Student(int roll_num, String name) {
        this.roll_num = roll_num;
        this.name = name;
    }

    public int getRollNum() {
        return roll_num;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return roll_num == student.roll_num && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return 31 * roll_num + name.hashCode();
    }
}

class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    // Insert at the end
    public void insert(Student s) {
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Delete first occurrence matching student (roll_num and name)
    public void delete(Student s) {
        if (head == null) return;

        // If head is the target
        if (head.data.equals(s)) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null && !curr.next.data.equals(s)) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    // Print all students
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.println("Roll: " + curr.data.getRollNum() +
                                ", Name: " + curr.data.getName());
            curr = curr.next;
        }
    }
}

// Main class – file name must be part2.java
public class part2 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(102, "Bob");
        Student s3 = new Student(103, "Charlie");

        list.insert(s1);
        list.insert(s2);
        list.insert(s3);

        System.out.println("List after insertions:");
        list.printList();

        // Delete Bob
        list.delete(s2);
        System.out.println("\nList after deleting Bob:");
        list.printList();

        // Try deleting a student not in the list
        Student s4 = new Student(104, "David");
        list.delete(s4);
        System.out.println("\nAfter trying to delete David (not in list):");
        list.printList();
    }
}