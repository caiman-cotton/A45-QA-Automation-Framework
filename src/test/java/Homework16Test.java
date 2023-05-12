import FactoryPages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16Test extends BaseTest{
    @Test
    public void registrationNavigation() {
        LoginPage loginPage = new LoginPage(getDriver());
        //click and verify
        loginPage.clickRegistrationLink();
        WebElement registrationField = getDriver().findElement(By.cssSelector("input[value='register']"));
        Assert.assertTrue(registrationField.isDisplayed());

    }
}
