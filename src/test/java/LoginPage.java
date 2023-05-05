import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //locators

   private By emailField = By.cssSelector("input[type='email']");
   private By passwordField = By.cssSelector("input[type='password']");
   private By submitBtn = By.cssSelector("button[type='submit']");
   private By registrationLink = By.cssSelector("a[type='submit']");
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
    }
    public void logInMeToKoel() {
        inputEmail("caiman.cotton@testpro.io");
        inputPassword("te$t$tudent");
        clickSubmitBtn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
    }
    public void clickRegistrationLink() {
        findElement(registrationLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Register']")));
    }
}
