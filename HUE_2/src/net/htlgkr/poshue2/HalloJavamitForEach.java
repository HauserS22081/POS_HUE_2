package net.htlgkr.poshue2;

import java.util.ArrayList;
import java.util.List;

public class HalloJavamitForEach {

    public static void halloJavaMitForEach() {
        List<String> stringList = new ArrayList<String>(List.of("a", "b", "c", "d", "e", "f"));

        System.out.println("Mit for each Schleife: ");
        for (String element : stringList) {
            System.out.println(element);
        }

        System.out.println("\nMit lambda Ausdruck:");
        stringList.forEach(System.out::println);
    }
}
