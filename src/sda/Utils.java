package sda;

import static sda.Main.random;

public class Utils {
    public static String randomPesel() {
        StringBuilder pesel = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            pesel.append(random.nextInt(10));
        }
        return pesel.toString();
    }
}
