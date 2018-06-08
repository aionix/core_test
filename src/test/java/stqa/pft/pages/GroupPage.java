package stqa.pft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import stqa.pft.appmanager.BasePage;
import stqa.pft.model.GroupData;

public class GroupPage extends BasePage {
    public GroupPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "delete")                      public WebElement deleteButton;
    @FindBy(name = "new")                         public WebElement newGroupButton;
    //Gr creation page
    @FindBy(name = "submit")                      public WebElement subminGroupCreateButton;
    @FindBy(name = "group_name")                  public WebElement groupNameField;
    @FindBy(name = "group_header")                public WebElement groupHeaderField;
    @FindBy(name = "group_footer")                public WebElement groupFooterField;


    @Step("User removes selected group")
    public void deleteSelectedGroup() {
        click(deleteButton);
    }

    @Step("User selects group")
    public void selectGroup()         { click(By.name("selected[]")); }
    public void submitGroupCreation() {
        click(subminGroupCreateButton);
    }

    @Step("User initiates group creation")
    public void initGroupCreation()   { click(newGroupButton);    }

    @Step("User fills group form: name, header, footer")
    public void fillGroupForm(GroupData groupData) {
        type(groupNameField, groupData.getName());
        type(groupHeaderField, groupData.getHeader());
        type(groupFooterField, groupData.getFooter());
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }}
}
