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

    //O(1)
    public void addFront(int data) {
        head = new Node(data, head);
    }

    //O(1)
    public int getFirst() {
        return head.data;
    }

    //O(n)
    public int getLast() {
        Optional<Node> node = getTail(); //O(n)

        return node.orElseThrow(() -> new NoSuchElementException("No items in list")).data;
    }

    //O(n)
    private Optional<Node> getTail() {
        Node node = head;
        while (node != null && node.next != null)
            node = node.next;

        return Optional.ofNullable(node);
    }

    //O(n)
    public void addBack(int data) {
        Node back = new Node(data, null);
        Optional<Node> tail = getTail();
        if (tail.isPresent())
            tail.get().next = back;
        else
            head = back;
    }

    //O(n)
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

    // O(n)
    public void deleteValue(int data) {
        Node node = head;
        if (head.data == data) {
            head = head.next;
            return;
        }
        while (node.next != null) { //O(n)
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
