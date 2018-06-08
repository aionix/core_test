package utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

public class FileUtilz {
    public static void main(String[] args){
        writeToFile();
    }


    public static String getFilePath(String fileName) {
        String path = System.getProperty("user.dir") + "/src/main/resources/"+fileName;
        return new File(path).getPath();
    }

    public static void getFilePathFromPC(String fileName) {
        String externalPath = "D:/local_proj/temp/"+fileName;
        System.out.println(new File(externalPath).exists());
    }

    public static String readFromPropertiesFile(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        //key : value
        String file = System.getProperty("target", fileName);
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", file))));
        return properties.getProperty(key);
    }

    public static void takeScreenshotSaveToFolder(WebDriver driver){
        String scrFile = "D:\\2\\file_"+NumbersGenerator.getCurrentTime()+".png";
        try {
            FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(scrFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFile(){
        String scrFile = "D:\\2\\file_"+NumbersGenerator.getCurrentTime()+".png";
            new File(scrFile);
    }
}
