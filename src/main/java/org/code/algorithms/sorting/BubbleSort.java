package org.code.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int data[] = new int[]{4,2,1,3,6};
        sort(data);
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        int length = data.length;
        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
            if (!swapped) break;
        }
    }
}
