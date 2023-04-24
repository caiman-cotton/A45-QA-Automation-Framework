import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist() {
      options.addArguments("--remote-allow-origins=*");
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
