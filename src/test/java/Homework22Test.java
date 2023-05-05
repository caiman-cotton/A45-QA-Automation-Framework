import org.testng.Assert;
import org.testng.annotations.Test;

//The homework instructions didn't specifically say to write a specific test!
//I will present the previous Homework (Homework 21) test, now referencing POM
public class Homework22Test extends BaseTest {
    @Test
    public void renamePlaylist() {
        String notificationText = "Updated playlist \"newName.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logInMeToKoel();
        homePage.createPlaylist("renameThis");
        homePage.renameThePlaylistWithDoubleClick("renameThis", "newName");
        Assert.assertEquals(notificationText, homePage.getNotificationText());
        homePage.deleteThePlaylist();
    }
}
