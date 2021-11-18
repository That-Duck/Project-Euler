package com.company;

public class CollatzSequence {
    long limit;
    long[] values;
    long arrayLimit;

    CollatzSequence() {
    }

    public long longestChain(long limit) {
        this.limit = limit;
        this.arrayLimit = limit * 100;
        values = new long[(int)arrayLimit];
        ArrayFunctions.longArrayFill(values, 0);
        values[1] = 1;

        long longestChain = 1;
        long answer = 1;
        for (long i = 2; i < limit; i++) {
            if (countChain(i) > longestChain) {
                longestChain = values[(int)i];
                answer = i;
            }
        }

        return answer;
    }

    private long countChain(long n) {
        if (n < arrayLimit) {
            if (values[(int)n] > 0) {
                return values[(int)n];
            }
        }

        long c = 0;
        if (n % 2 == 0) {
            c = 1 + countChain(n / 2);
        } else {
            c = 2 + countChain((3 * n + 1) / 2);
        }

        //This section prevent out of bounds errors. The program will run out of
        //heap space if you just try to make a bigger array.
        if (n < arrayLimit) {
            values[(int)n] = c;
        } else {return c;}

        return values[(int)n];
    }

}
