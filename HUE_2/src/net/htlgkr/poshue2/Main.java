package net.htlgkr.poshue2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("second Assignment\n");
        HalloJavamitForEach.halloJavaMitForEach();

        NumberTester numberTester = new NumberTester("testSecondAssignment.txt");
        numberTester.setOddEvenTester(number -> (number % 2) == 0);
        numberTester.setPrimeTester(Main::isPrime);
        numberTester.setPalindromeTester(Main::isPalindrom);

        System.out.println("\n\nthird Assignment\n");
        numberTester.testFile();

    }

    private static boolean isPrime(int number) {
        EratosthenesPrimeSieve primeSieve = new EratosthenesPrimeSieve(1000);

        return primeSieve.isPrime(number);
    }

    private static boolean isPalindrom(int number) {
        List<Integer> digits = getDigits(number);
        for (int i = 0; i < (digits.size() / 2); i++) {
            if (!digits.get(i).equals(digits.get(digits.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number = number / 10;
        }

        return digits;
    }
}

