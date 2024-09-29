package net.htlgkr.poshue2;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    private static void interactWithUser(AbstractCalculator[] calculatorArray) {
        // calculatorArry:
        // 0: relational calculator, 1: vector calculator, 2: complex calculator

        Scanner scanner = new Scanner(System.in);
        AbstractCalculator calculator = null;

        while (true) {

            System.out.println("Choose calculator: ");
            System.out.println("1 - Relational calculator");
            System.out.println("2 - Vector calculator");
            System.out.println("3 - Complex calculator");
            System.out.println("4 - Exit program");
            int choice = scanner.nextInt();

            if (choice == 4) break;

            switch (choice) {
                case 1:
                    calculator = calculatorArray[0];
                    break;
                case 2:
                    calculator = calculatorArray[1];
                    break;
                case 3:
                    calculator = calculatorArray[2];
                    break;
                default:
                    System.out.println("invalid input!");
                    continue;
            }


            int operation = 5;
            Number number1= null;
            Number number2 = null;

            while (operation == 5) {
                System.out.print("Enter number x a > ");
                double a = scanner.nextDouble();
                System.out.print("Enter number x b > ");
                double b = scanner.nextDouble();
                number1 = new Number(a, b);

                System.out.print("Enter number y a > ");
                a = scanner.nextDouble();
                System.out.print("Enter number y b > ");
                b = scanner.nextDouble();
                number2 = new Number(a, b);


                System.out.println("Choose operation:");
                System.out.println("1 - add");
                System.out.println("2 - subtract");
                System.out.println("3 - multiply");
                System.out.println("4 - divide");
                System.out.println("5 - enter numbers again");
                operation = scanner.nextInt();
            }

            System.out.println("-------------------------------");

            Number result = null;
            switch (operation) {
                case 1:
                    result = calculator.add(number1, number2);
                    break;
                case 2:
                    result = calculator.subtract(number1, number2);
                    break;
                case 3:
                    result = calculator.multiply(number1, number2);
                    break;
                case 4:
                    result = calculator.divide(number1, number2);
                    break;
                default:
                    System.out.println("invalid input!");
                    continue;
            }

            System.out.println("Solution:");
            System.out.println("a = " + result.getA());
            System.out.println("b = " + result.getB());
            System.out.println("-------------------------------");
        }

        scanner.close();
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

