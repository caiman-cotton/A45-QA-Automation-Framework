import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }



    ChromeOptions options = new ChromeOptions();

    WebDriver driver = new ChromeDriver(options);

    @BeforeMethod
    public void setupOptions() {
        options.addArguments("--remote-allow-origins=*");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void getLink(String link) {
        driver.get(link);}

    public void signInEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email]"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void signInPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogIn() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public void searchSong(String song) {
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(song);
    }

    public void viewAllTheSongs() {
        WebElement viewAllSongs = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllSongs.click();
    }

    public void chooseFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']"));
        firstSong.click();
    }

    public void addToPlaylist(String playlist) {
        WebElement addButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addButton.click();
        WebElement playlistName = driver.findElement(By.cssSelector("input[data-test='new-playlist-name']"));
        playlistName.click();
        playlistName.sendKeys(playlist);
        WebElement enterPlaylist = driver.findElement(By.cssSelector("button[title='Save']"));
        enterPlaylist.click();
    }

    public void showsPopUp() {
        WebElement success = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(success.isDisplayed());
    }

    public void showsPopUpText() {
        WebElement successText = driver.findElement(By.xpath("//div[(contains(text(), 'Added 1 song into" + playlist));
        Assert.assertTrue(successText.isDisplayed());
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}