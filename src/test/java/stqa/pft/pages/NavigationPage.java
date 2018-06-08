package stqa.pft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import stqa.pft.appmanager.BasePage;

/**
 * Created by Artem.Buchynskyi on 25.10.2017.
 */
public class NavigationPage extends BasePage {
    public NavigationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "groups")                      public WebElement groupsLink_mainNavigationMenu;
    @FindBy(linkText = "group page")                  public WebElement groupPageLink;
    @FindBy(linkText = "Logout")                      public WebElement logout;

    @Step("Go to groups page")
    public void gotoGroupPage() { groupsLink_mainNavigationMenu.click(); }
    public void returnToGroupsPage() {
        groupPageLink.click();
    }

    @Step("Log out")
    public void logout() {        logout.click(); }

}
