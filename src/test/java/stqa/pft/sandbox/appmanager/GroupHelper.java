package stqa.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import stqa.pft.sandbox.model.GroupData;

/**
 * Created by Artem.Buchynskyi on 25.10.2017.
 */
public class GroupHelper extends HelperBase {
    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void logout() {
        click(By.linkText("Logout"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }
    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }
}
