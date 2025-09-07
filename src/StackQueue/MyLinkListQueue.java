package StackQueue;

public class MyLinkListQueue implements IStackQueue {
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node current = head;

    public MyLinkListQueue() {
        head = null;
    }

    @Override
    public void push(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = current = newNode;
        } else {
            current.next = newNode;
            current = newNode;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int value = head.value;
        if (head == current) {
            head = current = null;
        } else {
            head = head.next;
        }

        return value;
    }

    @Override
    public int peek() {
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
