import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String link;
    WebDriverWait wait;
    Actions actions;
    ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        link = BaseURL;
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        getDriver().get(link);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
    public WebDriver getDriver() {
        return threadDriver.get();
    }
    public static WebDriver pickBrowser(String browser) {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.14:4444";
        switch (browser) {
            case "MicrosoftEdge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return getDriver() = new EdgeDriver(edgeOptions);
            }
            case "grid-edge" -> {
                caps.setCapability("browserName", "MicrosoftEdge");
                try {
                    return getDriver() = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return getDriver() = new FirefoxDriver();
            }
            case "grid-firefox" -> {
                caps.setCapability("browserName", "firefox");
                try {
                    return getDriver() = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "grid-chrome" -> {
                caps.setCapability("browserName", "chrome");
                try {
                    return getDriver() = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return getDriver() = new ChromeDriver(options);
            }
        }
    }


    public void logInMeToKoel() {
        inputEmail("caiman.cotton@testpro.io");
        inputPassword("te$t$tudent");
        clickSubmit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
}
    @AfterMethod
    public void endTest() {
        getDriver().quit();
        threadDriver.remove();
    }

    public void inputEmail(String email) {
        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void inputPassword(String password) {
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submitBtn = getDriver().findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
    }
public void searchSongTitle(String songTitle) {
        WebElement searchSong = getDriver().findElement(By.cssSelector("input[type='search']"));
        searchSong.click();
                searchSong.sendKeys(songTitle);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results section.songs h1 button")));
}
public void clickViewAllBtn() {
        WebElement viewAllBtn = getDriver().findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
}
public void selectFirstSongBySearch() {
        WebElement firstSongResult = getDriver().findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.btn-add-to")));
}
public void clickAddToBtn() {
        WebElement addToBtn = getDriver().findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]")));
}
public void addToPlaylist() {
        WebElement ourPlaylist = getDriver().findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]"));
        ourPlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
}
public String getNotificationText() {
        WebElement notification = getDriver().findElement(By.cssSelector("div.success.show"));
        return notification.getText();
}
    public void playASong() {
        WebElement playNextBtn = getDriver().findElement(By.cssSelector("i[data-testid='play-next-btn']"));

        WebElement playBtn = getDriver().findElement(By.cssSelector("span[data-testid='play-btn']"));
        playNextBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='play-btn']")));
        playBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='sound-bar-play']")));
    }
    public boolean isSongPlaying() {
        WebElement soundImage = getDriver().findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        return soundImage.isDisplayed();
    }
    public void createPlaylist(String nameOfPlaylist) {
        WebElement playlistCreationBtn = getDriver().findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        playlistCreationBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        WebElement newPlaylistCreation = getDriver().findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistCreation.click();
        WebElement fieldNamePlaylist = getDriver().findElement(By.xpath("//section[@id='playlists']//input[@name='name']"));
        fieldNamePlaylist.click();
        fieldNamePlaylist.sendKeys(nameOfPlaylist);
        fieldNamePlaylist.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.success.show")));
    }
    public void clickPlaylistName(String nameOfPlaylist) {
        WebElement myPlaylist = getDriver().findElement(By.xpath("//section[@id='playlists']//a[contains(text(), '" + nameOfPlaylist + "')]"));
        myPlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
    }
    public void deleteThePlaylist() {
        WebElement playlistDeleteBtn = getDriver().findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        playlistDeleteBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    }
    public void clickHome() {
        WebElement homeBtn = getDriver().findElement(By.xpath("//nav[@id='sidebar']//a[@class='home']"));
        homeBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='home active']")));
    }
    public void clickRegistrationLink() {

        WebElement registrationLink = getDriver().findElement(By.cssSelector("a[type='submit']"));
        registrationLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Register']")));
    }
    public void renameThePlaylistWithDoubleClick(String playlistName, String renamedPlaylist) {
        WebElement myPlaylistName = getDriver().findElement(By.xpath("//section[@id='playlists']//a[contains(text(), '" + playlistName + "')]"));
        actions.doubleClick(myPlaylistName).perform();
        WebElement playlistNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistNameInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameInputField.sendKeys(renamedPlaylist);
        playlistNameInputField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));

    }
}