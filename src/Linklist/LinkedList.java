package Linklist;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addLast(int value) {

        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void addMiddle(int afterValue, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            System.out.println("List is empty. Cannot insert after " + afterValue);
            return;
        }

        Node current = head;
        while (current != null && current.value != afterValue) {
            current = current.next;
        }

        // Nếu không tìm thấy afterValue
        if (current == null) {
            System.out.println("Value " + afterValue + " not found in the list.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteNode(int value) {

        if (head == null) {
            System.out.println("List is empty. Cannot insert after " + value);
            return;
        }

        if (head.value == value) { // Nếu Node đầu tiên cần xóa
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value " + value + " not found in the list.");
            return;
        }

        current.next = current.next.next;
    }


    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.print("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst(8);

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addMiddle(5, 10);

        list.addMiddle(8, 9);

        list.deleteNode(4);
        list.deleteNode(9);
        list.deleteNode(10);
        list.deleteNode(6);
        list.deleteNode(3);


        list.printList();
    }
}
//8 -> 9 -> 4 -> 5 -> 10 -> 6 -> null
//Ghi chú:

//Add at first case:
//Condition:
// No

//Add at last case:
//Condition:
//Case 1: head == null
//Case 2: current.next != null

//Add at middle case:
//Condition:
//Case 1: head == null --> print: not found list
//Case 2: current != null && current.value != afterValue
//Case 3: current = null

//Delete Node:
//Condition:
//Case 1: Delete head
//Case 2: if empty
//Case 3:
