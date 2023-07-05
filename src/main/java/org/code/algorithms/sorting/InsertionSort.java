package org.code.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int data[] = new int[]{4,2,1,3,6};
        sort(data);
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        int size = data.length;
        for (int i = 1; i < size; i++) {
            int key = data[i];
            int j = i - 1;
            // Compare key with each element on the left of it until an element smaller than it is found.
            while (j >= 0 && key < data[j]) {
                data[j+1] = data[j];
                --j;
            }
            // Place key at after the element just smaller than it.
            data[j+1] = key;
        }
    }
}
