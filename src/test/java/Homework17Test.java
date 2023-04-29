import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17Test extends BaseTest{
    @Test
    public void addSongToPlaylist() {
        String newSongAddedNotificationText = "Added 1 song into \"playlist.\"";
inputEmail("caiman.cotton@testpro.io");
inputPassword("te$t$tudent");
clickSubmit();
searchSongTitle("Mid-Air Machine");
clickViewAllBtn();
selectFirstSongBySearch();
clickAddToBtn();
addToPlaylist();
Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));

        }
    }

