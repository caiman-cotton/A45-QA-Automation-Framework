/*With no specific instructions for a test, I am presenting the same test as last time,
but with fluency chaining added in, referencing the FactoryPages which now replace the previous Pages.
 */
import FactoryPages.HomePage;
import FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23Test extends BaseTest{
    @Test
    public void renamePlaylist() {
        String notificationText = "Updated playlist \"newName.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.logInMeToKoel();
        homePage.createPlaylist("renameThis")
        .renameThePlaylistWithDoubleClick("renameThis", "newName");
        Assert.assertEquals(notificationText, homePage.getNotificationText());
        homePage.clickHome()
                .clickPlaylistName("newName")
                .deleteThePlaylist();
    }
}
