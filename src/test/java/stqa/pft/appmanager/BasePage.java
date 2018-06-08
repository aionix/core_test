package stqa.pft.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public void click(WebElement element) {
        element.click();
    }


    public void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void getTime(){

    }
}
