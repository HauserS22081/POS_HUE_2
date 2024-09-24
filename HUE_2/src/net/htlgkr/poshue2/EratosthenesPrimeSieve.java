package net.htlgkr.poshue2;

import java.util.Arrays;

public class EratosthenesPrimeSieve implements PrimeSieve{

    private boolean[] areNumbersPrimes;
    private int upperBound;

    public EratosthenesPrimeSieve(int upperBound) {
        // length = upperBound - 1 -> because then areNumbersPrimes[2] =^ 2;
        areNumbersPrimes = new boolean[upperBound + 1];
        this.upperBound = upperBound;

        // at beginning every number is a Prime and they get false when they are the product of another number
        fillArrayWithTrue(areNumbersPrimes);

        makeAllNumbersThatAreNotPrimesFalse(areNumbersPrimes, upperBound);
    }

    private void makeAllNumbersThatAreNotPrimesFalse(boolean[] areNumbersPrimes, int upperBound) {

        areNumbersPrimes[0] = false;
        areNumbersPrimes[1] = false;

        for (int i = 2; i < Math.sqrt(upperBound); i++) {

            if (areNumbersPrimes[i]) {

                for (int j = i*i; j <= upperBound; j += i) {
                    areNumbersPrimes[j] = false;
                }
            }
        }
    }

    private void fillArrayWithTrue(boolean[] array) {
        Arrays.fill(array, true);
    }

    @Override
    public boolean isPrime(int p) {
        return areNumbersPrimes[p];
    }

    @Override
    public void printPrimes() {
        for (int i = 2; i <= upperBound; i++) {
            if(areNumbersPrimes[i]) {
                System.out.print(i + (i % upperBound == 0 ? " " : ", "));
            }
        }
    }
}

