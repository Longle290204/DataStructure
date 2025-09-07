package StackQueue;

public class MyArrayStack implements IStackQueue {

    private int top;
    private int[] arr;
    private int capacity;

    public MyArrayStack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }

        arr[++top] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return arr[top--];
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return arr[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.print("Stack is empty");
            return;
        }

        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack(5);

        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.show();
        System.out.println("Pop: " + stack.pop());

        stack.show();

    }
}
