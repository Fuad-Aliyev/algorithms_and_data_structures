package org.code.data_structures.stack.array;

import java.util.List;

public interface ArrayStack<T> {
    void push(T value);

    T pop();

    T peek();

    long size();

    List<T> getStackAndEmpty();

    void flush();
}
