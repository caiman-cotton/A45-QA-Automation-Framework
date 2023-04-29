import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16Test extends BaseTest{
    @Test
    public static void registrationNavigation() {
        //click and verify
        WebElement registrationLink = driver.findElement(By.cssSelector("a[type='submit']"));
        registrationLink.click();
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed());
    }
}
