public class Homework19Test extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        launchChrome();
        logInMeToKoel(link);
        //create a playlist so we can delete it
        createPlaylist("DeleteThis");
        //go to homepage to test the functionality when clicking on the playlist name
        clickHome();

    }
}
