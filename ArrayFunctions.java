package com.company;

public class ArrayFunctions {

    public static int[] intToArray(int number) {

        if (number == 0) {
            int[] digitArray = new int[1];
            digitArray[0] = 0;
            return digitArray;
        }

        int length = 0;
        int p = number;
        while (p > 0) {
            p = p / 10;
            length++;
        }

        int[] digitArray = new int[length];
        int n = number;
        int i = length - 1;
        while (n > 0) {
            digitArray[i] = n % 10;
            n /= 10;
            n--;
        }

        return digitArray;

    }


    public static long arrayToInt (int[] array, int start, int digits) {
        long number = 0;
        long place = 1;
        for (int i = start + digits - 1; i > start - 1; i--) {
            number += array[i] * place;
            place *= 10;
        }
        return number;
    }


    public static void intArrayFill(int[] array, int value) {
        int len = array.length;

        if(len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, ((len - i) < i) ? (len - i) : i);
        }
    }


    public static void longArrayFill(long[] array, int value) {
        int len = array.length;

        if(len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, ((len - i) < i) ? (len - i) : i);
        }
    }

}
