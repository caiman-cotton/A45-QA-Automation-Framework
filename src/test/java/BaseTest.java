import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void songSearch(String song) {
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.click();
        searchBar.clear();
        String song ="Mid-Air Machine";
        searchBar.sendKeys("Mid-Air Machine");
    }

    public void addToButton(){
        WebElement addButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addButton.click();
    }

    public void makeChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    public void makeDriver() {
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openLink() {
        String link = "https://bbb.testpro.io/";
        driver.get(link);
    }

    public void addPlaylist() {
        WebElement playlistName = driver.findElement(By.cssSelector("input[data-test='new-playlist-name']"));
        playlistName.click();
        playlistName.sendKeys("playlist");
        WebElement enterPlaylist = driver.findElement(By.cssSelector("button[title='Save']"));
        enterPlaylist.click();
    }
}