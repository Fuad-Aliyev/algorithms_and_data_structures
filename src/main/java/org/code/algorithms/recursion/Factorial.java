package org.code.algorithms.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(findFactorialRecursive(2));
        System.out.println(findFactorialIterative(2));
    }

    private static int findFactorialRecursive(int number) {
        if (number == 1) {
            return 1;
        }
        return number * findFactorialRecursive(number-1);
    }

    private static int findFactorialIterative(int number) {
        int answer = 1;
        if (number == 2) {
            return 2;
        }
        for (int i = 2; i <= number; i++) {
            answer = answer * i;
        }
        return answer;
    }
}
