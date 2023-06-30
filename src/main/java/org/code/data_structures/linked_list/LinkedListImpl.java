package org.code.data_structures.linked_list;

public class LinkedListImpl<E> implements LinkedList<E> {
    private int size;
    private Node<E> head;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addFront(E value) {
        Node<E> node = new Node<>(value);
        if (this.head == null) {
            this.head = node;
            this.size++;
            return;
        }
        node.next = this.head;
        this.size++;
    }

    @Override
    public void addBack(E value) {
        Node<E> node = new Node<>(value);
        if (this.head == null) {
            this.head = node;
            this.size++;
            return;
        }
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        this.size++;
    }

    @Override
    public E get(int index) {
        if (this.size == 0 || index > this.size - 1) {
            return null;
        }
        if (index == 0) {
            return (E) this.head.value;
        }
        int currentIndex = 0;
        Node<E> currentNode = this.head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (++currentIndex == index) {
                return (E) currentNode.value;
            }
        }
        return null;
    }

    @Override
    public E getFirst() {
        return (E) this.head.value;
    }

    @Override
    public E getLast() {
        Node<E> currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentNode.next == null) {
                return (E) currentNode.value;
            }
        }
        return null;
    }

    @Override
    public void removeFirst() {
        if (this.size == 0) {
            return;
        }
        Node<E> currentHead = this.head;
        this.head = this.head.next;
        currentHead.value = null;
        currentHead.next = null;
        this.size--;
    }

    @Override
    public void removeLast() {
        if (this.size == 0) {
            return;
        }
        Node<E> currentNode = this.head;
        if (currentNode.next == null) {
            currentNode.value = null;
            this.size--;
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentNode.next.next == null) {
                currentNode.next.value = null;
                currentNode.next = null;
                this.size--;
                return;
            }
        }
    }

    @Override
    public void removeValue(E value) {
        if (this.head == null) {
            return;
        }
        if (this.head.value == value) {
            this.head = this.head.next;
            this.size--;
            return;
        }
        Node<E> currentNode = this.head;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                this.size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    @Override
    public void clear() {
        while (this.size != 0) {
            this.removeFirst();
        }
    }

    @Override
    public void reverse() {
        if (this.size == 1) {
            System.out.println(this.head);
        }
        Node currentNode = this.head;
        while (currentNode.next != null) {
            this.head = currentNode.next;
            currentNode.next = currentNode;
            currentNode = currentNode.next;
        }
    }
}
