import FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInNoCredentialsTest extends BaseTest {
    @Test
    public void logInNoCredentials() {
        String url = "https://bbb.testpro.io/";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .clickSubmitBtnGoingNowhere();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
