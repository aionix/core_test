package stqa.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Artem.Buchynskyi on 25.10.2017.
 */
public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.get("http://localhost/addressbook/");
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.cssSelector("input[type=\"submit\"]"));
    }
}
