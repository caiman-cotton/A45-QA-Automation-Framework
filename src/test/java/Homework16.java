import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public static void registrationNavigation() {
        //ChromeOptions arguments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //set and get URL
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        //click registration
        WebElement registration = driver.findElement(By.cssSelector("a[type='submit']"));
        registration.click();
        //unique element to verify reg page
        WebElement uniqueForm = driver.findElement(By.cssSelector("form[method='POST']"));
        //verify reg page
        Assert.assertTrue(uniqueForm.isDisplayed());

        driver.quit();
    }
}