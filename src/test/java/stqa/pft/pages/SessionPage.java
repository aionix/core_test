package stqa.pft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import stqa.pft.appmanager.BasePage;

public class SessionPage extends BasePage {
    public SessionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "user")                  public WebElement loginInput;
    @FindBy(name = "pass")                  public WebElement passwordInput;
    @FindBy(css = "input[value=Login]")     public WebElement submitButton;
    @FindBy(css = "input[name=new]")        public WebElement newGroupButton;



    public void login(String username, String password) {
        type(loginInput, username);
        type(passwordInput, password);
        click(driver.findElement(By.cssSelector("#LoginForm>input[value='Login']")));
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(newGroupButton));
        //click(submitButton);
    }









}

