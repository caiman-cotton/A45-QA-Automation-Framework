import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String link;
    WebDriverWait wait;
    Actions actions;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchChrome(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        link = BaseURL;
        driver = new ChromeDriver(options);
        driver.get(link);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public void logInMeToKoel() {
        inputEmail("caiman.cotton@testpro.io");
        inputPassword("te$t$tudent");
        clickSubmit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='main']")));
}
    @AfterMethod
    public void endTest() {
        driver.quit();
    }

    public static void inputEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void inputPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='main']")));
    }
public void searchSongTitle(String songTitle) {
        WebElement searchSong = driver.findElement(By.cssSelector("input[type='search']"));
        searchSong.click();
                searchSong.sendKeys(songTitle);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results section.songs h1 button")));
}
public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
}
public void selectFirstSongBySearch() {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.btn-add-to")));
}
public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]")));
}
public void addToPlaylist() {
        WebElement ourPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]"));
        ourPlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
}
public String getNotificationText() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
}
    public void playASong() {
        WebElement playNextBtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));

        WebElement playBtn = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playNextBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='play-btn']")));
        playBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='sound-bar-play']")));
    }
    public boolean isSongPlaying() {
        WebElement soundImage = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        return soundImage.isDisplayed();
    }
    public void createPlaylist(String nameOfPlaylist) {
        WebElement playlistCreationBtn = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        playlistCreationBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        WebElement newPlaylistCreation = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistCreation.click();
        WebElement fieldNamePlaylist = driver.findElement(By.xpath("//section[@id='playlists']//input[@name='name']"));
        fieldNamePlaylist.click();
        fieldNamePlaylist.sendKeys(nameOfPlaylist);
        fieldNamePlaylist.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.success.show")));
    }
    public void clickPlaylistName(String nameOfPlaylist) {
        WebElement myPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//a[contains(text(), '" + nameOfPlaylist + "')]"));
        myPlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
    }
    public void deleteThePlaylist() {
        WebElement playlistDeleteBtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        playlistDeleteBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    }
    public void clickHome() {
        WebElement homeBtn = driver.findElement(By.xpath("//nav[@id='sidebar']//a[@class='home']"));
        homeBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='home active']")));
    }
    public void clickRegistrationLink() {

        WebElement registrationLink = driver.findElement(By.cssSelector("a[type='submit']"));
        registrationLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Register']")));
    }
    public void renameThePlaylistWithDoubleClick(String playlistName, String renamedPlaylist) {
        WebElement myPlaylistName = driver.findElement(By.xpath("//section[@id='playlists']//a[contains(text(), '" + playlistName + "')]"));
        actions.doubleClick(myPlaylistName).perform();
        WebElement playlistNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistNameInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameInputField.sendKeys(renamedPlaylist);
        playlistNameInputField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));

    }
}