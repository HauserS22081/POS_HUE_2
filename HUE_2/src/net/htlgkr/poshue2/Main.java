package net.htlgkr.poshue2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Second Assignment\n");
        HalloJavamitForEach.halloJavaMitForEach();


        System.out.println("\n\nThird Assignment\n");

        NumberTester numberTester = new NumberTester("testSecondAssignment.txt");
        numberTester.setOddEvenTester(number -> (number % 2) == 0);
        numberTester.setPrimeTester(Main::isPrime);
        numberTester.setPalindromeTester(Main::isPalindrom);

        numberTester.testFile();


        System.out.println("\n\nFourth Assignment\n");

        AbstractCalculator[] calculator = createCalculator();

        interactWithUser(calculator);
    }

    private static void interactWithUser(AbstractCalculator[] calculator) {
        
    }

    private static AbstractCalculator[] createCalculator() {
        RelationalCalculator relationalC = new RelationalCalculator(
                (a, b) -> new Number(a.getA() + b.getA(), a.getB() + b.getB()),
                (a, b) -> new Number(a.getA() - b.getB(), a.getB() - b.getB()),
                (a, b) -> new Number(a.getA() * b.getA(), a.getB() * b.getB()),
                (a, b) -> new Number(a.getA() * b.getB(), a.getB() * b.getA())
        );

        VectorCalculator vectorC = new VectorCalculator(
                (a, b) -> new Number(a.getA() + b.getA(), a.getB() + b.getB()),
                (a, b) -> new Number(a.getA() - b.getA(), a.getB() - b.getB()),
                (a, b) -> new Number(0, a.getA() * b.getB() - a.getB() * b.getA()),
                (a, b) -> new Number(a.getA() * b.getA() + a.getB() * b.getB(), 0)
        );

        ComplexCalculator complexC = new ComplexCalculator(
                (a, b) -> new Number(a.getA() + b.getA(), a.getB() + b.getB()),
                (a, b) -> new Number(a.getA() - b.getA(), a.getB() - b.getB()),
                (a, b) -> new Number(a.getA() * b.getA() - a.getB() * b.getB(), a.getA() * b.getB() + a.getB() * b.getA()),
                (a, b) -> new Number(
                        (a.getA() * b.getA() + b.getB() * b.getB()) / (Math.pow(b.getA(), 2) + Math.pow(b.getB(), 2)),
                        (a.getB() * b.getA() - a.getA() * b.getB()) / (Math.pow(b.getA(), 2) + Math.pow(b.getB(), 2)))
        );

        return new AbstractCalculator[]{relationalC, vectorC, complexC};
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

