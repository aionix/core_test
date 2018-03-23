package stqa.pft.sandbox.appmanager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.PageFactory;
import stqa.pft.sandbox.helpers.NumbersGenerator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static stqa.pft.sandbox.helpers.NumbersGenerator.*;
import static stqa.pft.sandbox.model.BrowserType.*;


public class ApplicationManager {
    private final Properties properties;
    private final String propsFile;
    public WebDriver driver;
    public String  browser;
    public GroupPage groupHelper;
    public NavigationPage navigationHelper;
    public SessionPage sessionHelper;

    public ApplicationManager(String browser, String propsFile) {
        this.browser = browser;
        properties = new Properties();
        this.propsFile = propsFile;
    }

    public void init() throws IOException {
        String target = System.getProperty("target", propsFile );
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browser.equals(IE)){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        groupHelper =      PageFactory.initElements(driver, GroupPage.class);
        navigationHelper = PageFactory.initElements(driver, NavigationPage.class);
        sessionHelper =    PageFactory.initElements(driver, SessionPage.class);

        driver.manage().window().maximize();
        driver.get(properties.getProperty("web.url"));
        sessionHelper.login(properties.getProperty("user_admin_login"), properties.getProperty("user_admin_password"));
    }

    public void stop() {
        driver.close();
        driver.quit();
    }
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



}
