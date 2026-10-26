class ArrayStack {
    private int[] arr;    // storage
    private int top;      // index of top element (-1 = empty)

    public ArrayStack(int capacity) {
        arr = new int[capacity];
        top = -1;                         // empty at start
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    // Add x on top
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;                   // move top up, then place value
    }

    // Remove and return top
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];                // return value, then move top down
    }

    // Return top without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    // Print from top to bottom
    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(5);

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