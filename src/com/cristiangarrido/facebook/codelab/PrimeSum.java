package com.cristiangarrido.facebook.codelab;

import java.util.ArrayList;

/**
 * Solution for https://codelab.interviewbit.com/problems/primesum/
 */
public class PrimeSum {

    public static void main(String[] args){
        PrimeSum sol = new PrimeSum();
        System.out.println(sol.primesum(5));
        System.out.println(sol.primesum(20));
        System.out.println(sol.primesum(16777214));
        //System.out.println(sol.isPrime);
        System.out.println(PrimeSum.isPrime.length);
    }

    private static Boolean[] isPrime = new Boolean[0];//Integer.MAX_VALUE];

    private ArrayList<Integer> primesum(int target) {

        ensurePrimeNumbers(target);

        ArrayList<Integer> result = new ArrayList<>(2);
        for (int i = 2; i <= Math.sqrt(target); i++) {
            if (isPrime[i] && isPrime[target - i]){
                result.add(i);
                result.add(target - i);
                return result;
            }
        }
        return null;
    }

    private static void ensurePrimeNumbers(int N){
        if(N > isPrime.length){
            isPrime = new Boolean[N + 1];
            isPrime[0] = false;
            isPrime[1] = false;

            for (int i = 2 ; i <= N; i++){
                isPrime[i] = true;
            }

            for (int i = 2; i <= Math.sqrt(N); i++){
                if (!isPrime[i]) continue;
                for (int j = i * i; j <= N; j += i)
                    isPrime[j] = false;
            }
        }
    }
}

