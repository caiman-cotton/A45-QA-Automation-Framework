import FactoryPages.HomePage;
import FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17Test extends BaseTest{
    @Test
    public void addSongToPlaylist() {
        String newSongAddedNotificationText = "Added 1 song into \"playlist.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
loginPage.inputEmail("caiman.cotton@testpro.io")
        .inputPassword("te$t$tudent")
        .clickSubmitBtn();
homePage.createPlaylist("playlist")
        .clickHome()
        .searchSongTitle("Mid-Air Machine")
        .clickViewAllBtn()
        .selectFirstSongBySearch()
        .clickAddToBtn()
        .addToPlaylist();
Assert.assertTrue(homePage.getNotificationText().contains(newSongAddedNotificationText));
homePage.clickHome()
        .clickPlaylistName("playlist")
        .deleteThePlaylist();
        }
    }

