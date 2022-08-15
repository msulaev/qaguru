package utils;

import java.util.Random;

public class Utils {

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
