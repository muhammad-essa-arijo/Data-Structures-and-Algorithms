class LinkedQueue {
    private Node front;    // first node (dequeue from here)
    private Node rear;     // last node (enqueue here)

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Add x at the rear
    public void enqueue(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            front = rear = n;        // first node is both front and rear
            return;
        }
        rear.next = n;               // old last -> new node
        rear = n;                    // new node becomes rear
    }

    // Remove and return front
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        int x = front.data;
        front = front.next;          // move front forward
        if (front == null) {
            rear = null;             // queue became empty
        }
        return x;
    }

    // Return front without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    // Print from front to rear
    public void printQueue() {
        for (Node p = front; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Queue (front to rear):");
        q.printQueue();                              // 10 20 30

        System.out.println("Peek: " + q.peek());     // 10
        System.out.println("Dequeue: " + q.dequeue()); // 10
        System.out.println("Dequeue: " + q.dequeue()); // 20

        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Is empty? " + q.isEmpty()); // false
        System.out.println("Now:");
        q.printQueue();                              // 30 40 50
    }
}