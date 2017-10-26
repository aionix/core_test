package stqa.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Artem.Buchynskyi on 25.10.2017.
 */
public class HelperBase {

    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
