package stqa.pft.sandbox.helpers;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class NumbersGenerator {

    public static void main(String[] args) throws IOException {
        System.out.println(readFromFile("local2", "web.url"));
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

    public static String readFromFile(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        //key : value
        String file = System.getProperty("target", fileName);
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", file))));
        return properties.getProperty(key);
    }

    public void takeScreenshot2(){
        String scrFile = "D:\\2\\file_"+NumbersGenerator.getCurrentTime()+".png";
        //FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(scrFile));
    }
}
