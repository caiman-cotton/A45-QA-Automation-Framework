import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17Test extends BaseTest {
    public Homework17Test() {
    }

    @Test
    public void addSongToPlaylist() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getLink("https://bbb.testpro.io/");
        signInEmail("caiman.cotton@testpro.io");
        signInPassword("te$t$tudent");
        clickLogIn();
        searchSong("Mid-Air Machine");
        viewAllTheSongs();
        chooseFirstSong();
        addToPlaylist("playlist");
        showsPopUp();
        showsPopUpText();
        driver.quit();
    }
}
