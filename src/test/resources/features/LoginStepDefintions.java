import io.cucumber.java.en.And;

public class LoginStepDefintions {
    WebDriver driver;
    WebDriver wait;
    String link;
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup;
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
