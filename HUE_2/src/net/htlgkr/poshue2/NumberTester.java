package net.htlgkr.poshue2;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumberTester {


    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private String fileName;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        Map<Integer, Integer> file = readInFile();

        // file.forEach((key, value) -> useNumberTester(key, value));

        file.forEach(this::useNumberTester);
    }

    private void useNumberTester(int key, int value) {
        switch (key){
            case 1:
                System.out.println(oddTester.testNumber(value) ? "EVEN" : "ODD"); return;
            case 2:
                System.out.println(primeTester.testNumber(value) ? "PRIME" : "NOT PRIME"); return;
            case 3:
                System.out.println(palindromeTester.testNumber(value) ? "PALINDROME" : "NOT PALINDROME");
        }
    }

    private Map<Integer, Integer> readInFile() {
        Map<Integer, Integer> file = new LinkedHashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))){
            String line = br.readLine();
            line = br.readLine();
            while(line != null){
                String[] parts = line.split(" ");
                file.put(Integer.parseInt(parts[0]), Integer.valueOf(parts[1]));
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error in NumberTester.readInFile - Message: " + e.getMessage());
        }

        return file;
    }

}
