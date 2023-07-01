package org.code.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("---RECURSIVE---");
        System.out.println(fibonacciRecursive(3));
        System.out.println("---ITERATIVE---");
        fibonacciIterative(3);
    }

    //O(2^n)
    private static int fibonacciRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    //O(n)
    private static void fibonacciIterative(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i <= n; i++) {
            list.add(list.get(i-2) + list.get(i-1));
        }
        System.out.println(list);
    }
}
