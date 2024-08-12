public class ArrayStack {
    private int[] stackArray;
    private int top;
    private int capacity;

    // Construtor
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[capacity];
        this.top = -1; // Inicializa top como -1 para indicar que a pilha está vazia
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return top == -1;
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Adiciona um elemento na pilha
    public void push(int item) {
        if (isFull()) {
            System.out.println("Pilha cheia. Não é possível adicionar o item: " + item);
            return;
        }
        stackArray[++top] = item; // Incrementa top e adiciona o item na pilha
    }

    // Remove um elemento da pilha
    public int pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia. Não é possível remover elementos.");
            return -1; // Retorna -1 para indicar que a pilha está vazia
        }
        return stackArray[top--]; // Retorna o item no topo e decrementa top
    }

    // Retorna o elemento no topo da pilha sem removê-lo
    public int peek() {
        if (isEmpty()) {
            System.out.println("Pilha vazia. Não há elementos para visualizar.");
            return -1; // Retorna -1 para indicar que a pilha está vazia
        }
        return stackArray[top];
    }

    // Exibe a pilha
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Pilha vazia.");
            return;
        }
        System.out.print("Elementos na pilha: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.displayStack();

        stack.pop();
        stack.pop();

        stack.displayStack();

        System.out.println("Elemento no topo: " + stack.peek());

        stack.push(60);
        stack.push(70);

        stack.displayStack();
    }
}
