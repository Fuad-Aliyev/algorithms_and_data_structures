package org.code.hash_table;

public class Node<T> {
    protected Node next;
    protected Node prev;
    protected T key;
    protected T value;

    public Node(T key, T value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", prev=" + prev +
                ", key=" + key +
                ", value=" + value +
                '}';
    }
}
