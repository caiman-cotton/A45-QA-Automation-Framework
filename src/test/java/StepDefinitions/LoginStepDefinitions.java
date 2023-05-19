package StepDefinitions;

import FactoryPages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    String link;
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I am on login page")
    public void getLoginPage() {
        link = "https://bbb.testpro.io";
        driver.get(link);
    }
    @When("I enter email {string}")
    public void enterEmail() {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.inputEmail("caiman.cotton@testpro.io");
    }
    @And("I enter password {string}")
    public void enterPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword("te$t$tudent");
    }
    @And("I click submit button")
    public void clickSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }
    @Then("I am logged in")
    public void loggedInAssessment() {
        Assert.assertTrue(driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")).isDisplayed());

    }
}
