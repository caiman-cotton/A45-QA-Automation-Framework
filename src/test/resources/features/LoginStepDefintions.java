import io.cucumber.java.en.And;

public class LoginStepDefintions {
    WebDriver driver;
    WebDriver wait;
    String link;
    @Given("I am on login page")
    @Parameters({BaseURL})
    public void getLoginPage() {
        WebDriverManager.chromedriver().setup;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        link = BaseURL;
        driver.get(link);

    }
    @When("I enter email {string}")
    public void enterEmail() {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.inputEmail();
    }
    @And("I enter password {string}")
    public void enterPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword();
    }
    @And("I click submit button")
    public void clickSubmit() {
        loginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }
    @Then("I am logged in")
    public void loggedInAssessment() {
        Assert.assertTrue(driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")).isDisplayed);

    }
}
