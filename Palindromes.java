package com.company;

public class Palindromes {

    public static boolean isPalindrome (int number) {
        int num = number;
        int test = 0;

        while (num > 0) {
            test *= 10;
            test += num % 10;
            num /= 10;
        }

        if (test == number) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome(int number, int base) {
        int num = number;
        int test = 0;

        while (num > 0) {
            test *= base;
            test += num % base;
            num /= base;
        }

        if (test == number) {
            return true;
        }
        return false;
    }

    public static int createPalindrome(int number, boolean hasOddDigits) {
        int num = number;
        int palindrome = number;
        int digit;

        if (hasOddDigits) {
            num = num / 10;
        }

        while (num > 0) {
            palindrome *= 10;
            palindrome += num % 10;
            num /= 10;
        }

        return palindrome;
    }
}
