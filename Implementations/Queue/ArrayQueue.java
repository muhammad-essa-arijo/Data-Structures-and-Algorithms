class ArrayQueue {
    private int[] arr;     // storage
    private int front;     // index of first element
    private int size;      // how many elements now
    private int capacity;  // max elements

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // Add x at the rear
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        int rear = (front + size) % capacity;   // next free slot (wraps around)
        arr[rear] = x;
        size++;
    }

    // Remove and return front
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        int x = arr[front];
        front = (front + 1) % capacity;         // move front forward (wraps around)
        size--;
        return x;
    }

    // Return front without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    // Print from front to rear
    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[(front + i) % capacity]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);

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