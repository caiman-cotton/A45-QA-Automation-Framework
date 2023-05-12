import FactoryPages.HomePage;
import FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19Test extends BaseTest {
    @Test
    public void deletePlaylist() {
       String deletedPlaylistText =  "Deleted playlist \"DeleteThis.\"";
       LoginPage loginPage = new LoginPage(getDriver());
       HomePage homePage = new HomePage(getDriver());
        loginPage.logInMeToKoel();
        //create a playlist so we can delete it
        homePage.createPlaylist("DeleteThis")
        //go to homepage to test the functionality when clicking on the playlist name
                .clickHome()
                .clickPlaylistName("DeleteThis")
                .deleteThePlaylist();
        Assert.assertTrue(homePage.getNotificationText().contains(deletedPlaylistText));
    }
}
