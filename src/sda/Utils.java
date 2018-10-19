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

    public static double nanoToSeconds(long nanoSeconds) {
        return (double) nanoSeconds /1000000000;
    }

    public static double nanoToMilliSeconds(long elapsed2) {
        return (double) elapsed2/1000000;
    }
}
