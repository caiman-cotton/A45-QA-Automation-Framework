package FactoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //locators
    @FindBy(css="input[type='email']")
    private WebElement emailField;
    @FindBy(css="input[type='password']")
    private WebElement passwordField;
    @FindBy(css="button[type='submit']")
    private WebElement submitBtn;
    @FindBy(css="a[type='submit']")
    private WebElement registrationLink;

    public void inputEmail(String email) {
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void inputPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmitBtn() {
        submitBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
    }
    public void logInMeToKoel() {
        inputEmail("caiman.cotton@testpro.io");
        inputPassword("te$t$tudent");
        clickSubmitBtn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
    }
    public void clickRegistrationLink() {
        registrationLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Register']")));
    }
}
