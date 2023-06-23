package org.code.array_list;

public interface CustomArrayList<T> {
    void set(int index, T value);
    T get(int index);
    int size();
    boolean isEmpty();
    void add(T value);
    void insert(int index, T value);
    void delete(int index);
    boolean contains(T value);
}
