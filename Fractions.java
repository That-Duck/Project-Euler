package com.company;

public class Fractions {

    public static int longestReciprocalSequenceDenominator(int n) {
        int longestSequence = 0;
        int sequenceLength = 0;
        int denominator = 0;

        for (int i = 1; i < n; i++) {
            int[] remainderPositions = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                remainderPositions[j] = 0;
            }

            int remainder = 1;
            int position = 1;

            while (remainderPositions[remainder] == 0) {
                remainderPositions[remainder] = position;
                remainder *= 10;
                remainder %= i;
                position++;
            }

            sequenceLength = position - remainderPositions[remainder];
            if (sequenceLength > longestSequence) {
                longestSequence = sequenceLength;
                denominator = i;
            }
        }

        return denominator;
    }

    public static void orderedFractions() {
        int n = 1;
        int d = 2;
        int j;
        double fraction = 3.0 / 7.0;
        double difference;
        double m = 8.0 / 3.0;
        double minDifference = fraction - (3.0/8.0);

        for (int i = 1; i <= (int)Math.floor(1000000.0 * 3.0 / 7.0); i++) {
            j = (int)Math.floor((double)i * m);
            difference = fraction - ((double)i / (double)j);
            if (difference < minDifference && difference > 0) {
                minDifference = difference;
                n = i;
                d = j;
                m = (double)j / (double)i;
            }
        }

        System.out.println(n + "/" + d);
    }
}
