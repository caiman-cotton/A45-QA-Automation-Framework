import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //locators

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public void inputEmail(String email) {
        findElement(emailField).click();
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }
    public void inputPassword(String password) {
        findElement(passwordField).click();
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmitBtn() {
        findElement(submitBtn).click();
    }
    public void logInMeToKoel() {
        inputEmail("caiman.cotton@testpro.io");

    }
}
