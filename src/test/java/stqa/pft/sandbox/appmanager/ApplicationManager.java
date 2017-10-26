package stqa.pft.sandbox.appmanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import static org.openqa.selenium.remote.BrowserType.*;

/**
 * Created by Artem.Buchynskyi on 25.10.2017.
 */
public class ApplicationManager {
    public WebDriver driver;
    public String  browser;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;
    public SessionHelper sessionHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
           // System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriverr.exe");
            driver = new ChromeDriver();
        } if(browser.equals(BrowserType.IE)){
            System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().deleteAllCookies();
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }
    public void stop() {
        driver.close();
        driver.quit();

    }

}
