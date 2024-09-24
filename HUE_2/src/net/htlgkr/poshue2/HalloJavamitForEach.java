package net.htlgkr.poshue2;

import java.util.ArrayList;
import java.util.List;

public class HalloJavamitForEach {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>(List.of("a", "b", "c", "d", "e", "f"));

        for (String element : stringList) {
            System.out.println(element);
        }

        stringList.forEach(System.out::println);
    }
}
