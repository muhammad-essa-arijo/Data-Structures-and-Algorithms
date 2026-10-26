class LinkedList {
    private static class Node {
        private int data;                    // value stored
        private Node next;                   // link to next node

        public Node(int data) {              // standalone node, next = null
            this.data = data;
        }
        public Node(int data, Node next) {   // node linked to an existing node
            this.data = data;
            this.next = next;
        }
    }

    // Traverse: start at head, move until null
    private Node head;
    public void printList() {
        for (Node p = head; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    // Insert x into sorted list (small to big)
    public void insert(int x) {
        Node p = head;

        // Empty list or x is smallest: new node becomes head
        if (head == null || head.data > x) {
            head = new Node(x, head);
            return;
        }

        // Stop at the node just BEFORE the insert position
        while (p.next != null) {
            if (p.next.data > x) break;      // next is bigger, stop here
            p = p.next;                      // else move forward
        }

        // Link new node: new -> p.next, then p -> new
        p.next = new Node(x, p.next);
    }

    // Delete x from sorted list
    public void delete(int x) {
        // Empty list or x smaller than head: x cannot exist
        if (head == null || head.data > x) {
            return;
        }

        // x is the first node: move head forward
        if (head.data == x) {
            head = head.next;
            return;
        }

        // Look at p.next (stay one node BEHIND the target)
        for (Node p = head; p.next != null; p = p.next) {
            if (p.next.data > x) break;      // passed x, not in list
            if (p.next.data == x) {
                p.next = p.next.next;        // skip the target node
                break;
            }
        }
    }
}

public class LinkedListImple {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();      // empty list

        list.insert(20);                      // 20
        list.insert(10);                      // 10 -> 20
        list.insert(30);                      // 10 -> 20 -> 30
        list.insert(25);                      // 10 -> 20 -> 25 -> 30

        System.out.println("After inserts:");
        list.printList();                        // 10 20 25 30

        list.delete(20);                      // remove a middle node
        list.delete(10);                      // remove the head
        list.delete(99);                      // not in list, nothing happens

        System.out.println("After deletes:");
        list.printList();                        // 25 30
    }
}
