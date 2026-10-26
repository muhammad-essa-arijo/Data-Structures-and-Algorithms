class LinkedStack {
    private Node top;                     // head of list = top of stack

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Add x on top: new node -> old top, then becomes top
    public void push(int x) {
        top = new Node(x, top);
    }

    // Remove and return top
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        int x = top.data;                 // save value
        top = top.next;                   // move top to next node
        return x;
    }

    // Return top without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // Print from top to bottom
    public void printStack() {
        for (Node p = top; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    public static void main(String[] args) {
        LinkedStack s = new LinkedStack();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Stack (top to bottom):");
        s.printStack();                   // 30 20 10

        System.out.println("Peek: " + s.peek());   // 30
        System.out.println("Pop: " + s.pop());     // 30
        System.out.println("Pop: " + s.pop());     // 20

        System.out.println("Is empty? " + s.isEmpty());  // false

        System.out.println("After pops:");
        s.printStack();                   // 10
    }
}