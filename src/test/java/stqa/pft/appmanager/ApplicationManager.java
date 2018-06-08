package stqa.pft.appmanager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import stqa.pft.pages.GroupPage;
import stqa.pft.pages.NavigationPage;
import stqa.pft.pages.SessionPage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static stqa.pft.model.BrowserType.*;


public class ApplicationManager {
    private final Properties properties;
    private final String propsFile;
    public WebDriver driver;
    public String  browser;
    public GroupPage groupHelper;
    public NavigationPage navigationHelper;
    public SessionPage sessionHelper;

    public ApplicationManager(String browser, String environment) {
        this.browser = browser;
        properties = new Properties();
        this.propsFile = environment;
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
        } else if (browser.equals(FIREFOX)){
            FirefoxOptions options = new FirefoxOptions().setLegacy(true);
            driver = new FirefoxDriver(options);
        }

        groupHelper =      PageFactory.initElements(driver, GroupPage.class);
        navigationHelper = PageFactory.initElements(driver, NavigationPage.class);
        sessionHelper =    PageFactory.initElements(driver, SessionPage.class);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void openLoginPage() {
        driver.get(properties.getProperty("web.url"));
        sessionHelper.login(properties.getProperty("user_admin_login"), properties.getProperty("user_admin_password"));
    }

    public void stop() {
        if (driver != null){
            driver.quit();
        }
    }
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //running allure cli to generate report after all tests execution
    public static void generateReports() {
        exec("cmd /c c:/Tools/allure-2.4.1/bin/allure.bat generate -c build/allure-results" );
    }

    private static void exec(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        } }



}
