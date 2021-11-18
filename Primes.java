package com.company;
import java.util.Arrays;
import java.util.ArrayList;

public class Primes {

    public static boolean[] sieve(int range) {

        if (range < 2) {
            throw new IllegalArgumentException("Range too small.");
        }

        boolean[] primeSieve = new boolean[range + 1];
        Arrays.fill(primeSieve, false);
        primeSieve[0] = true;
        primeSieve[1] = true;

        double dRange = (double)(range + 1);
        int root = (int)Math.floor(Math.sqrt(dRange));
        int composite;
        int limit;

        for (int i = 4; i <= range; i += 2) {
            primeSieve[i] = true;
        }

        for (int i = 3; i <= root; i += 2) {
            limit = range / i;
            if (!primeSieve[i]) {
                for (int j = i; j <= limit; j += 2) {
                    composite = i * j;
                    primeSieve[composite] = true;
                }
            }
        }

        return primeSieve;
    }
    
    
    public static Integer[] factors (int number) {

        ArrayList<Integer> factorList = new ArrayList<Integer>();
        int factor = 2;
        boolean[] sieve = sieve(number);
        int num = number;

        while(factor <= num) {
            if(!sieve[factor]) {
                if(num % factor == 0) {
                    factorList.add(factor);
                    num = num / factor;
                } else { factor++; }
            } else { factor++; }
        }

        Integer[] factorArray = new Integer[factorList.size()];
        factorList.toArray(factorArray);
        return factorArray;
    }


    public static int[] primeArray(int size) {
        int[] primes = new int[size];
        boolean[] sieve = sieve(size * 10);

        int n = 0;
        int i = 2;
        while (n < size) {
            if (!sieve[i]) {
                primes[n] = i;
                n++;
            }
            i++;
            if (i >= sieve.length) {
                sieve = sieve(sieve.length*10);
            }
        }

        return primes;
    }

}
