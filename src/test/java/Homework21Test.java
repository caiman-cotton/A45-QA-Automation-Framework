import org.testng.annotations.Test;
import org.testng.Assert;
public class Homework21Test extends BaseTest{
    @Test
    public void renamePlaylist() {
        String renamedNotificationText = "Updated playlist \"renamedPlaylist.\"";
        logInMeToKoel();
        //create playlist so we can change its name
        createPlaylist("defaultName");
        renameThePlaylistWithDoubleClick("defaultName", "renamedPlaylist");
        Assert.assertEquals(getNotificationText(), renamedNotificationText);
        deleteThePlaylist();


    }
}
