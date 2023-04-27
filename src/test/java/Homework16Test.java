import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16Test extends BaseTest{
    @Test
    public static void registrationNavigation() {
        //stuff to make the test work in Chrome
     launchChrome();

    String url = "https://bbb.testpro.io/";
    driver.get(url);
        //click and verify
        WebElement registrationLink = driver.findElement(By.cssSelector("a[type='submit']"));
        registrationLink.click();
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed());
        driver.quit();
    }
}
