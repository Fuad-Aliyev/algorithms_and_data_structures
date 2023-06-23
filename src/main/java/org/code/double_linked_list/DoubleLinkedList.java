package org.code.double_linked_list;

public interface DoubleLinkedList<T> {
    int size();

    boolean isEmpty();

    void addFirst(T value);

    void addLast(T value);

    void iterateForward();

    void iterateBackward();

    T removeFirst();

    T removeLast();
}
