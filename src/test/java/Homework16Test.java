import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16Test extends BaseTest{
    @Test
    public void registrationNavigation() {
        //click and verify
        clickRegistrationLink();
        Assert.assertTrue(registerButton.isDisplayed());

    }
}
