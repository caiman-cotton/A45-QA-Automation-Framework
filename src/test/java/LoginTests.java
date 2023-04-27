import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        launchChrome();

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
