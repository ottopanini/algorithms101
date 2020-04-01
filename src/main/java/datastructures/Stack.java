package datastructures;

import java.util.EmptyStackException;

// LIFO - Last In First Out

public class Stack {

    private class Node {
        private int data;
        private Node next;
        private Node (int data) {
            this.data = data;
        }
    }

    private Node head; // add and remove things here
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
    }

    public int pop() {
        if (head == null) throw new EmptyStackException();
        int ret = head.data;
        head = head.next;
        size--;
        return ret;
    }

    public int size() {
        return size;
    }
}
