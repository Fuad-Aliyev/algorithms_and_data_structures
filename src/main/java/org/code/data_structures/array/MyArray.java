package org.code.data_structures.array;

import java.lang.reflect.Array;

public class MyArray<T> {
    public int length;
    private T[] data;

    public MyArray(Class<T> clazz, int capacity) {
        this.data = (T[]) Array.newInstance(clazz, capacity);
    }

    public <T> T get(int index) {
        return (T) this.data[index];
    }

    public void push(T data) {
        this.data[this.length] = data;
        this.length++;
    }

    public <T> T pop() {
        T lastItem = (T) this.data[this.length-1];
        this.data[this.length-1] = null;
        this.length--;
        return lastItem;
    }

    public void delete(int index) {
        shiftItems(index);
    }

    private void shiftItems(int index) {
        for (int i = index; i < this.length - 1; i++) {
            this.data[i] = this.data[i+1];
        }
    }
}
