package com.company;

public class Multiples {

    public static int leastCommonMultiple(int[] factors) {

        int greatest = 0;
        for (int i = 0; i < factors.length; i++) {
            if (factors[i] > greatest) {
                greatest = factors[i];
            }
        }

        int[] primes = Primes.primeArray(greatest);
        int[] primePowers = new int[greatest];
        ArrayFunctions.intArrayFill(primePowers, 0);

        int power = 0;
        int p = 0;
        int i = 0;
        int n;
        for (int f : factors) {
            n = f;
            i = 0;
            p = 0;
            while(primes[i] <= n) {
                if (n % primes[i] == 0) {
                    n /= primes[i];
                    p++;
                    if (p > primePowers[i]) {
                        primePowers[i] = p;
                    }
                } else {
                    i++;
                    p = 0;
                }
            }
        }

        int LCM = 1;
        for (int j = 0; j < greatest; j++) {
            for (int m = 0; m < primePowers[j]; m++) {
                LCM *= primes[j];
            }
        }

        return LCM;
    }


    public static int factorial(int number) {
        int n = 1;
        for (int i = 1; i <= number; i++) {
            n *= i;
        }
        return n;
    }

}
