import org.testng.annotations.Test;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        setupOptions();
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
        tearDown();
    }
}
