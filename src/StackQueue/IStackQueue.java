package StackQueue;

public interface IStackQueue {
    public void push(int value);
    public int pop();
    public int peek();
    public boolean isEmpty();
    public boolean isFull();
    public void show();
}
