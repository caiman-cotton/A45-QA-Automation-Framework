import FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInWrongCredentialsTest extends BaseTest{
    @Test
    public void wrongCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        String url = "https://bbb.testpro.io/";
        loginPage
                .inputEmail("caiman.cotton@testpro.io")
                .inputPassword("te$tstudent")
                .clickSubmitBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
