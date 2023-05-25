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
    @FindBy(css="form[data-testid='login-form']")
    private WebElement loginForm;

    public LoginPage inputEmail(String email) {
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage inputPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn() {
        submitBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        return this;
    }
    public LoginPage logInMeToKoel() {
        inputEmail("caiman.cotton@testpro.io");
        inputPassword("te$t$tudent");
        clickSubmitBtn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        return this;
    }
    public LoginPage clickRegistrationLink() {
        registrationLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Register']")));
        return this;
    }
    public boolean isLoginFormVisible() {
        return loginForm.isDisplayed();
    }
    public LoginPage clickSubmitBtnGoingNowhere() {
        submitBtn.click();
        return this;
    }
}
