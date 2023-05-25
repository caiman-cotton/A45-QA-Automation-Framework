import FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationLinkTest extends BaseTest{
    @Test
    public void registrationNavigation() {
        LoginPage loginPage = new LoginPage(getDriver());
       String registrationUrl = "https://bbb.testpro.io/registration.php";
        //click and verify
        loginPage.clickRegistrationLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), registrationUrl);

    }
}
