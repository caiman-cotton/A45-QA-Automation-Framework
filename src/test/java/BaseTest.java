import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class BaseTest {
    public static WebDriver driver = null;
    public static String link = "https://bbb.testpro.io";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
    public static void goToPage() {
        driver.get(link);
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
    public static void clickSubmit() {
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }
public void searchSongTitle(String songTitle) throws InterruptedException {
        WebElement searchSong = driver.findElement(By.cssSelector("input[type='search']"));
        searchSong.click();
                searchSong.sendKeys(songTitle);
                Thread.sleep(5000);
}
public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllBtn.click();
        Thread.sleep(5000);
}
public void selectFirstSongBySearch() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(5000);
}
public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(5000);
}
public void addToPlaylist() throws InterruptedException {
        WebElement ourPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]"));
        ourPlaylist.click();
        Thread.sleep(2000);
}
public String getNotificationText() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
}
    public void playASong() throws InterruptedException {
        WebElement playNextBtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));

        WebElement playBtn = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playNextBtn.click();
        Thread.sleep(2000);
        playBtn.click();
        Thread.sleep(2000);
    }
    public boolean isSongPlaying() {
        WebElement soundImage = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        return soundImage.isDisplayed();
    }
}