package org.code.data_structures.double_linked_list;

public class DoubleLinkedListImpl<T> implements DoubleLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedListImpl() {
        size = 0;
    }

    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void addFirst(T value) {
        Node newNode = new Node(value, this.head, null);
        if (this.head != null) {
            this.head.prev = newNode;
        }
        this.head = newNode;
        if (this.tail == null) {
            this.tail = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        Node newNode = new Node(value, null, this.tail);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    @Override
    public void iterateForward() {
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.value + ", ");
            currentNode = currentNode.next;
        }
    }

    @Override
    public void iterateBackward() {
        Node currentNode = this.tail;
        while (currentNode != null) {
            System.out.print(currentNode.value + ", ");
            currentNode = currentNode.prev;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0)
            return null;
        Node currentNode = this.head;
        this.head = this.head.next;
        this.head.prev = null;
        size--;
        return currentNode.value;
    }

    @Override
    public T removeLast() {
        if (size == 0)
            return null;
        Node currentNode = this.tail;
        this.tail = this.tail.prev;
        this.tail.next = null;
        size--;
        return currentNode.value;
    }
}
