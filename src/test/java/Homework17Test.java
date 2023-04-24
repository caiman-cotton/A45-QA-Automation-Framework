import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.testng.Assert;
        import org.testng.annotations.Test;

        import java.time.Duration;

public class Homework17Test extends BaseTest {
    public Homework17Test(){
    }
    @Test
    public static void addSongToPlaylist() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String link = "https://bbb.testpro.io/";
        driver.get(link);
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email]"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("caiman.cotton@testpro.io");
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys("Mid-Air Machine");
        WebElement viewAllSongs = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllSongs.click();
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']"));
        firstSong.click();
        WebElement addButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addButton.click();
        WebElement playlistName = driver.findElement(By.cssSelector("input[data-test='new-playlist-name']"));
        playlistName.click();
        playlistName.sendKeys("playlist");
        WebElement enterPlaylist = driver.findElement(By.cssSelector("button[title='Save']"));
        enterPlaylist.click();
        WebElement success = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(success.isDisplayed());
        WebElement successText = driver.findElement(By.xpath("//div[(contains(text(), 'Added 1 song into playlist"));
        Assert.assertTrue(successText.isDisplayed());
        driver.quit();
    }
}