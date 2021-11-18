package com.company;
import java.util.Arrays;

public class Permutations {

    public static boolean isPermutation(int number, int test) {
        int[] num1 = ArrayFunctions.intToArray(number);
        int[] num2 = ArrayFunctions.intToArray(test);

        if (num1.length != num2.length) {
            return false;
        }

        Arrays.sort(num1);
        Arrays.sort(num2);

        for (int i = 0; i < num1.length; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }

        return true;
    }


    public static int coinCombinations(int[] coinValues, int target) {
        int[] combinations = new int[target + 1];
        Arrays.fill(combinations, 0);
        combinations[0] = 1;

        for (int v : coinValues) {
            for (int j = v; j <= target; j++) {
                combinations[j] += combinations[j - v];
            }
        }

        return combinations[target];
    }


    //isPandigital determines if a number's digits includes one
    //instance of every number from 0 to n or 1 to n.
    public static boolean isPandigital (int test, int n, boolean includesZero) {
        if (n > 10) { return false; }

        boolean[] foundDigits = new boolean[10];
        Arrays.fill(foundDigits, true);
        int start = includesZero ? 0 : 1;
        int expectedDigits = includesZero ? n + 1 : n;

        for (int i = start; i <= n; i++) {
            foundDigits[i] = false;
        }

        int num = test;
        int digits = 0;
        while (num > 0) {
            if (foundDigits[num % 10]) { return false; }
            foundDigits[num % 10] = true;
            num /= 10;
            digits++;
        }

        if (digits != expectedDigits) { return false; }

        return true;
    }

}
