package StackQueue;

import java.util.ArrayList;

public class MyLinkListStack implements IStackQueue {

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    Node topNode;

    public MyLinkListStack() {
        topNode = null;
    }

    @Override
    public void push(int value) {
        if (!isFull()) {
            Node newNode = new Node(value);
            newNode.next = topNode;
            topNode = newNode;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int value = topNode.value;
        topNode = topNode.next;
        return 0;
    }

    @Override
    public int peek() {
        return topNode.value;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.print("Stack is empty");
            return;
        }

        Node temp = topNode;
        ArrayList<Integer> listStack = new ArrayList<>();
        while (temp != null) {
//            System.out.print(temp.value + " ");
            listStack.add(temp.value);
            temp = temp.next;
        }

        for (int i = listStack.size() - 1; i >= 0; i--) {
            System.out.print(listStack.get(i) + " ");
        }
    }
}
