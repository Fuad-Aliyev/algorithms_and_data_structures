package org.code.data_structures.stack.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayStackImpl<T> implements ArrayStack<T> {
    private List<T> list;

    public ArrayStackImpl(List<T> list) {
        this.list = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        this.list.add(value);
    }

    @Override
    public T pop() {
        if (this.list.isEmpty()) {
            System.out.println("The stack is empty. Push a value before popping it.");
            return null;
        }
        T value = this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return value;
    }

    @Override
    public T peek() {
        if (this.list.isEmpty()) {
            System.out.println("The stack is empty. Push a value before popping it.");
            return null;
        }
        return this.list.get(this.list.size() - 1);
    }

    @Override
    public long size() {
        return this.list.size();
    }

    @Override
    public List<T> getStackAndEmpty() {
        List<T> stack = new ArrayList<>(this.list);
        this.list.removeAll(stack);
        return stack;
    }

    @Override
    public void flush() {
        this.list = new ArrayList<>();
    }
}
