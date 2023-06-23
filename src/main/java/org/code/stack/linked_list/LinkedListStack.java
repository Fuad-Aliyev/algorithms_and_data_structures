package org.code.stack.linked_list;

public interface LinkedListStack<T> {
    void push(T value);

    T peek();

    T pop();

    long size();
}
