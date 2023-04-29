import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16Test extends BaseTest{
    @Test
    public void registrationNavigation() {
        //click and verify
        clickRegistrationLink();
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed());

    }
}
