package org.code.queue.linked_list;

public interface Queue {
    int dequeue();

    void enqueue(int item);

    int peek();

    boolean isEmpty();

    int size();
}
