package datastructures;

import java.util.NoSuchElementException;
import java.util.Optional;

public class LinkedList {

    public class Node {
        private int data;
        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node head;

    public void addFront(int data) {
        head = new Node(data, head);
    }

    public int getFirst() {
        return head.data;
    }

    public int getLast() {
        Optional<Node> node = getTail();

        return node.orElseThrow(() -> new NoSuchElementException("No items in list")).data;
    }

    private Optional<Node> getTail() {
        Node node = head;
        while (node != null && node.next != null)
            node = node.next;

        return Optional.ofNullable(node);
    }

    public void addBack(int data) {
        Node back = new Node(data, null);
        Optional<Node> tail = getTail();
        if (tail.isPresent())
            tail.get().next = back;
        else
            head = back;
    }

    public int size() {
        Node node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }

        return size;
    }

    public void clear() {
        head = null;
    }

    public void deleteValue(int data) {
        Node node = head;
        if (head.data == data) {
            head = head.next;
            return;
        }
        while (node.next != null) {
            Node prevNode = node;
            node = node.next;
            if (data == node.data)
                prevNode.next = node.next;
        }
    }

    public void print() {
        int i = 0;
        for (Node node = head; node.next != null; node = node.next, i++)
            System.out.println("node[" + i + "]: " + node.data);
    }

}
