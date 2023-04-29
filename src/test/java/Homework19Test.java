import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework19Test extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
       String deletedPlaylistText =  "Deleted playlist \"DeleteThis.\"";
        logInMeToKoel();
        //create a playlist so we can delete it
        createPlaylist("DeleteThis");
        //go to homepage to test the functionality when clicking on the playlist name
        clickHome();
        clickPlaylistName("DeleteThis");
        deleteThePlaylist();
        Assert.assertTrue(getNotificationText().contains(deletedPlaylistText));
    }
}
