import FactoryPages.HomePage;
import FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{
    @Test
    public void logOut() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage
                .logInMeToKoel();
        homePage
                .clickLogOutBtn();
        Assert.assertTrue(loginPage.isLoginFormVisible());
    }
}
