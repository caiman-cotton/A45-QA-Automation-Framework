import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18Test extends BaseTest{
    @Test
    public void playSong() {
        goToPage();
        inputEmail("caiman.cotton@testpro.io");
        inputPassword("te$t$tudent");
        clickSubmit();
        playASong();
        Assert.assertTrue(isSongPlaying());
    }
}
