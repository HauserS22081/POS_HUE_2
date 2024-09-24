package net.htlgkr.poshue2;

import java.io.*;
import java.util.*;

public class NumberTester {


    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private String fileName;
    private List<Assignment2Model> lines;

    public NumberTester(String fileName) {
        this.fileName = fileName;
        lines = readInFile();
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
        lines.forEach(line -> useNumberTester(line.getType(), line.getNumber()));
    }

    private void useNumberTester(int type, int number) {
        switch (type){
            case 1:
                System.out.println(oddTester.testNumber(number) ? "EVEN" : "ODD"); return;
            case 2:
                System.out.println(primeTester.testNumber(number) ? "PRIME" : "NOT PRIME"); return;
            case 3:
                System.out.println(palindromeTester.testNumber(number) ? "PALINDROME" : "NOT PALINDROME");
        }
    }

    private List<Assignment2Model> readInFile() {
        List<Assignment2Model> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))){
            String line = br.readLine();
            line = br.readLine();
            while(line != null){
                String[] parts = line.split(" ");
                lines.add(new Assignment2Model(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error in NumberTester.readInFile - fileName - Message: " + e.getMessage());
        }

        return lines;
    }

}
