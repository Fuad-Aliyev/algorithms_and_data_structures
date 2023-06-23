package org.code.stack.linked_list;

public class LinkedListStackImpl<T> implements LinkedListStack<T> {
    private Node<T> top;
    private int size;

    public LinkedListStackImpl() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T value) {
        Node node = new Node();
        if (node == null) {
            System.out.println("Heap Overflow");
            return;
        }
        node.data = value;
        node.next = top;
        top = node;
        this.size++;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }
        return top.data;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }
        T top = peek();
        this.size--;
        this.top = (this.top).next;
        return top;
    }

    @Override
    public long size() {
        return size;
    }

    private class Node<T> {
        T data;
        Node next;
    }

    private boolean isEmpty() {
        return top == null;
    }
}
