package StackQueue;

public class MyArrayQueue implements IStackQueue {

    private int[] arr;
    private int capacity;
    private int headIndex;
    private int tailIndex;

    public MyArrayQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        headIndex = tailIndex = -1;
    }

    @Override
    public void push(int value) {
        if (!isFull()) {
            if (isEmpty()) {
                headIndex++;
            }
            arr[++tailIndex] = value;
        }
    }

    @Override
    public int pop() {
        int value = arr[headIndex++];
        if (!isEmpty()) {
            if (headIndex > tailIndex) {
                headIndex = tailIndex = -1;
            }
        }
        return value;
    }

    @Override
    public int peek() {
        return arr[headIndex];
    }

    @Override
    public boolean isEmpty() {
        return (headIndex == -1) && (tailIndex == -1);
    }

    @Override
    public boolean isFull() {
        return tailIndex == capacity - 1;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            for (int i = headIndex; i <= tailIndex; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
}
