package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static Map<String, String> getDate() {
        String[] keys = {"day", "month", "year"};
        return IntStream.range(0, keys.length).boxed()
                .collect(Collectors.toMap(i -> keys[i], i -> new SimpleDateFormat("dd/MMMM/yyyy").format(new Date()).split("/")[i]));
    }

}
