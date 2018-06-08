package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class NumbersGenerator {

    public static void main(String[] args) throws IOException {
        //System.out.println(FileUtilz.readFromPropertiesFile("local2", "web.url"));
        System.out.println(new File("").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
  }
    public static boolean isNullOrEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static String getCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String randomNumberFrom1To100() {
        final double max = 100;
        int t = (int) (Math.random() * max);
        return Integer.toString(t);
    }

    public static <T> T getRamdomItemFromList(List<T> list) {
        if (isNullOrEmpty(list)) {
                throw new MyExceptions("Empty list");
            }
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

}
