package stqa.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Artem.Buchynskyi on 25.10.2017.
 */
public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void returnToGroupsPage() {
        driver.findElement(By.linkText("group page")).click();
    }
    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

}
