import FactoryPages.HomePage;
import FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18Test extends BaseTest{
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.inputEmail("caiman.cotton@testpro.io")
                .inputPassword("te$t$tudent")
                .clickSubmitBtn();
        homePage.playASong();
        Assert.assertTrue(isSongPlaying());
    }
}
