public class ArrayQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Construtor
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Verifica se a fila está cheia
    public boolean isFull() {
        return size == capacity;
    }

    // Adiciona um elemento na fila
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Fila cheia. Não é possível adicionar o item: " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = item;
        size++;
    }

    // Remove um elemento da fila
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia. Não é possível remover elementos.");
            return -1; // Retorna -1 para indicar que a fila está vazia
        }
        int item = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Retorna o elemento na frente da fila sem remover
    public int peek() {
        if (isEmpty()) {
            System.out.println("Fila vazia. Não há elementos para visualizar.");
            return -1; // Retorna -1 para indicar que a fila está vazia
        }
        return queueArray[front];
    }

    // Retorna o tamanho atual da fila
    public int getSize() {
        return size;
    }

    // Exibe a fila
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.print("Elementos na fila: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.displayQueue();

        queue.dequeue();
        queue.dequeue();

        queue.displayQueue();

        System.out.println("Elemento na frente: " + queue.peek());

        queue.enqueue(60);
        queue.enqueue(70);

        queue.displayQueue();
    }
}
