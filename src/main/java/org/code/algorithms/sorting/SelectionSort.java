package org.code.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int data[] = new int[]{4,2,1,3,6};
        sort(data);
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        int size = data.length;
        for (int i = 0; i < size; i++) {
            int min_index = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j] < data[min_index]) {
                    min_index = j;
                }
            }
            int temp = data[i];
            data[i] = data[min_index];
            data[min_index] = temp;
        }
    }
}
