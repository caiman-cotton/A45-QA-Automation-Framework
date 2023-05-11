import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
//        driver.get(url);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
